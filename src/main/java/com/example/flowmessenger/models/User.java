package com.example.flowmessenger.models;

public class User {

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
//    private long lastSeen;

    public User() {}

    public User(String firstName,
                String lastName,
                String avatarPath,
                String username,
                char[] salt,
                char[] passwordHash,
                char[] recoveryKeyHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatarPath = avatarPath;
        this.username = username;
        this.salt = salt;
        this.passwordHash = passwordHash;
        this.recoveryKeyHash = recoveryKeyHash;
        createdAt = System.currentTimeMillis();
    }

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