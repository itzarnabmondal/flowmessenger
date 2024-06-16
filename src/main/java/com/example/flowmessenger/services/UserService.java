package com.example.flowmessenger.services;

import com.example.flowmessenger.models.User;
import com.example.flowmessenger.repositories.UserRepo;
import com.example.flowmessenger.security.Generator;
import com.example.flowmessenger.security.SHA3Hasher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    void register(String firstName,
                  String lastName,
                  String avatar_path,
                  String username,
                  char[] password) {
        char[] salt = Generator.generateSalt();
        char[] recoveryKey = Generator.generateRecoveryKey();
        var user = new User(
                firstName,
                lastName,
                avatar_path,
                username,
                salt,
                SHA3Hasher.getSHA3(password, salt),
                SHA3Hasher.getSHA3(recoveryKey, salt));
        userRepo.save(user);
    }

}