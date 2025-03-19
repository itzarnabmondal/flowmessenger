package com.example.flowmessenger.security;

import java.security.SecureRandom;

public final class Generator {

    private Generator() {
    }

    private static final byte KEY_SIZE = 32;

    private static final String SALT_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    private static final String RECOVERY_KEY_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789";

    private static char[] generate(String input) {
        var random = new SecureRandom();
        char[] key = new char[KEY_SIZE];
        for (int i = 0; i < KEY_SIZE; i++) {
            int index = random.nextInt(input.length());
            key[i] = input.charAt(index);
        }
        try {
            return key;
        } finally {
            key = null;
        }
    }

    public static char[] generateSalt() {
        return generate(SALT_STRING);
    }

    public static char[] generateRecoveryKey() {
        return generate(RECOVERY_KEY_STRING);
    }

}