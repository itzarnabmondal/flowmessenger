package com.example.flowmessenger.services;

import java.nio.file.Path;

import org.springframework.stereotype.Service;

import com.example.flowmessenger.models.User;
import com.example.flowmessenger.repositories.UserRepo;
import com.example.flowmessenger.security.Generator;
import com.example.flowmessenger.security.SHA3Hasher;

@Service
public class UserService {

    private User user;

    private String recoveryKey;

    private final UserRepo userRepo;

    public UserService(User user, UserRepo userRepo) {
        this.user = user;
        this.userRepo = userRepo;
    }

    public boolean register(String firstName, String lastName, Path avatarPath, String username, String password) {
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

    // Check if the username is already taken
    public boolean isUsernameTaken(String username) {
        return userRepo.existsByUsername(username);
    }

}
