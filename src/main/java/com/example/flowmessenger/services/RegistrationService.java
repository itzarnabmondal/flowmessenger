package com.example.flowmessenger.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.example.flowmessenger.models.User;

public class RegistrationService {

    private User user;

    public RegistrationService(User user) {
        this.user = user;
    }

    public boolean register(String firstName, String lastName, Path avatarPath, String username, String password) {
        // Save the user's information to the database
        // Save the user's avatar to the database
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
