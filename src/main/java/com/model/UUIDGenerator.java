package com.model;

import java.util.UUID;

/**
 * A class to generate UUIDs
 */
public class UUIDGenerator {

    /**
     * Generate a UUID
     * @return the generated UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        String uuid = UUIDGenerator.generateUUID();
        System.out.println("Generated UUID: " + uuid);
    }

}