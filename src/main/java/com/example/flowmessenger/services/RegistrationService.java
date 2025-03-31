package com.example.flowmessenger.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

import com.example.flowmessenger.models.User;
import com.example.flowmessenger.repositories.UserRepo;
import com.example.flowmessenger.security.Generator;
import com.example.flowmessenger.security.SHA3Hasher;

@Service
public class RegistrationService {

    private User user;

    private String recoveryKey;

    private final UserRepo userRepo;

    public RegistrationService(User user, UserRepo userRepo) {
        this.user = user;
        this.userRepo = userRepo;
    }

    public boolean register(String firstName, String lastName, Path avatarPath, String username, String password) {
        // Save the user's information to the database
        // Save the user's avatar to the database
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAvatarPath(avatarPath.toString());
        user.setUsername(username);
        user.setSalt(Generator.generateSalt());
        user.setPasswordHash(SHA3Hasher.getSHA3(password.toCharArray(), user.getSalt()));
        recoveryKey = Generator.generateRecoveryKey().toString();
        user.setRecoveryKeyHash(SHA3Hasher.getSHA3(recoveryKey.toCharArray(), user.getSalt()));
        user.setCreatedAt(System.currentTimeMillis());

        // Save the user to the database
        userRepo.save(user);
        return true;
    }

    public static Path saveUploadedFile(File uploadedFile,
                                  String originalFileName) throws IOException {
        String sanitizedFileName = sanitizeFileName(originalFileName);
        String userHome = System.getProperty("user.home");
        Path profilePhotosDir = Path.of(userHome, "flowmessenger", "profile-photos");
        if (!Files.exists(profilePhotosDir)) {
            Files.createDirectories(profilePhotosDir);
        }
        Path targetFilePath = profilePhotosDir.resolve(sanitizedFileName);
        int counter = 1;
        while (Files.exists(targetFilePath)) {
            String newFileName = getNewFileName(sanitizedFileName, counter);
            targetFilePath = profilePhotosDir.resolve(newFileName);
            counter++;
        }
        Files.move(uploadedFile.toPath(), targetFilePath);
        return targetFilePath;
    }

    private static String sanitizeFileName(String originalFileName) {
        return originalFileName.replaceAll("[^a-zA-Z0-9.-]", "_");
    }

    private static String getNewFileName(String originalFileName, int counter) {
        String fileNameWithoutExtension = originalFileName.replaceFirst("[.][^.]+$", "");
        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
        return fileNameWithoutExtension + "_" + counter + extension;
    }
}
