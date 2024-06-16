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

    public static char[] generateSalt() {
        var random = new SecureRandom();
        char[] key = new char[KEY_SIZE];
        for (int i = 0; i < KEY_SIZE; i++) {
            int index = random.nextInt(SALT_STRING.length());
            key[i] = SALT_STRING.charAt(index);
        }
        try {
            return key;
        } finally {
            key = null;
        }
    }

    public static char[] generateRecoveryKey() {
        var random = new SecureRandom();
        char[] key = new char[KEY_SIZE];
        for (int i = 0; i < KEY_SIZE; i++) {
            int index = random.nextInt(RECOVERY_KEY_STRING.length());
            key[i] = RECOVERY_KEY_STRING.charAt(index);
        }
        try {
            return key;
        } finally {
            key = null;
        }
    }

}