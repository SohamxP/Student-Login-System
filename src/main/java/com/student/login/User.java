package com.student.login;

public class User {
    private String fullName;
    private String email;
    private String username;
    private String passwordHash;

    public User(String fullName, String email, String username, String passwordHash) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    // Getters (no setters to keep immutability of stored fields)
    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Format as CSV line for storage: fullName,email,username,passwordHash
     */
    @Override
    public String toString() {
        return fullName + "," + email + "," + username + "," + passwordHash;
    }
}
