package com.example.flowmessenger.security;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SHA3Hasher {

    public static char[] getSHA3(final char[] password, final char[] salt) {
        ByteBuffer combinedBuffer = null;
        try {
            final ByteBuffer passwordBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(password));
            final ByteBuffer saltBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(salt));
            clearCharArray(password);
            clearCharArray(salt);
            combinedBuffer = ByteBuffer.allocate(passwordBuffer.remaining() + saltBuffer.remaining());
            combinedBuffer.put(passwordBuffer);
            combinedBuffer.put(saltBuffer);
            combinedBuffer.flip();
            clearByteBuffer(passwordBuffer);
            clearByteBuffer(saltBuffer);
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashBytes = digest.digest(combinedBuffer.array());
            clearByteBuffer(combinedBuffer);
            return bytesToHexCharArray(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA3-256 algorithm not available", e);
        } finally {
            if (combinedBuffer != null) {
                clearByteBuffer(combinedBuffer);
            }
        }
    }

    private static char[] bytesToHexCharArray(final byte[] bytes) {
        final char[] hexArray = "0123456789abcdef".toCharArray();
        final char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return hexChars;
    }

    private static void clearCharArray(final char[] array) {
        if (array != null) {
            Arrays.fill(array, '\0');
        }
    }

    private static void clearByteBuffer(final ByteBuffer buffer) {
        if (buffer != null) {
            for (int i = 0; i < buffer.capacity(); i++) {
                buffer.put(i, (byte) 0);
            }
        }
    }

}