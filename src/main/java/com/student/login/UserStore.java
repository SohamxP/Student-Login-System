package com.student.login;

import java.io.*;
import java.nio.file.*;

public class UserStore {
    private static final Path USERS_FILE = Paths.get("users.txt");

    /**
     * Adds a new user to the file. Returns true if added successfully.
     * Uses synchronized block to avoid race conditions on file I/O.
     */
    public static synchronized boolean addUser(User user) {
        try {
            // Ensure file exists; create if not.
            if (!Files.exists(USERS_FILE)) {
                Files.createFile(USERS_FILE);
            }
            // Append user record as a new line
            try (BufferedWriter writer = Files.newBufferedWriter(
                    USERS_FILE, StandardOpenOption.APPEND)) {
                writer.write(user.toString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Checks if a username is already taken by scanning the file line by line.
     */
    public static boolean userExists(String username) {
        try (BufferedReader reader = Files.newBufferedReader(USERS_FILE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[2].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // If the file doesn't exist yet, no users exist.
        }
        return false;
    }

    /**
     * Validates a username and plaintext password.
     * Returns true if a matching hashed password is found in the file.
     */
    public static boolean validateUser(String username, String password) {
        String hashedInput = PasswordUtil.hashPassword(password);
        try (BufferedReader reader = Files.newBufferedReader(USERS_FILE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // parts[2] = username, parts[3] = hashed password
                if (parts.length >= 4 && parts[2].equals(username)
                        && parts[3].equals(hashedInput)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // File not found or error means validation fails
        }
        return false;
    }
}
