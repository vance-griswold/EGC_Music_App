package com.model;

import java.util.UUID;

public class UUIDGenerator {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        String uuid = UUIDGenerator.generateUUID();
        System.out.println("Generated UUID: " + uuid);
    }

}