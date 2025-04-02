package com.example.flowmessenger.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;

public class StorageService {

    private static final SecureRandom random = new SecureRandom();

    public static Path saveUploadedFile(File uploadedFile, String originalFileName) throws IOException {
        String userHome = System.getProperty("user.home");
        Path profilePhotosDir = Path.of(userHome, "flowmessenger", "profile-photos");
        if (!Files.exists(profilePhotosDir)) {
            Files.createDirectories(profilePhotosDir);
        }
        String newFileName = generateRandomFileName(originalFileName);
        Path targetFilePath = profilePhotosDir.resolve(newFileName);
        Files.move(uploadedFile.toPath(), targetFilePath);
        return targetFilePath;
    }

    private static String generateRandomFileName(String originalFileName) {
        long randomNumber = 100_000_0000L + Math.abs(random.nextLong() % 900_000_0000L);
        String randomDigits = String.valueOf(randomNumber);
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return randomDigits + originalFileName.substring(dotIndex);
        }
        return randomDigits;
    }
}