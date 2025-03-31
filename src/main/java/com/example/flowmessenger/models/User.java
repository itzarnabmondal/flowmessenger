package com.example.flowmessenger.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

@Component
@Table("User")
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String avatarPath;
    private String username;
    private char[] salt;
    private char[] passwordHash;
    private char[] recoveryKeyHash;
    private long createdAt;
//    private boolean hasMFA;
//    private char[] pinHash;
//    private boolean isOnline;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }
    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getSalt() {
        return salt;
    }
    public void setSalt(char[] salt) {
        this.salt = salt;
    }

    public char[] getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(char[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public char[] getRecoveryKeyHash() {
        return recoveryKeyHash;
    }
    public void setRecoveryKeyHash(char[] recoveryKeyHash) {
        this.recoveryKeyHash = recoveryKeyHash;
    }

    public long getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

}