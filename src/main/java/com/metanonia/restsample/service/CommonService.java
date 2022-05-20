package com.metanonia.restsample.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonService {
    public static String Sha1(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(message.getBytes(StandardCharsets.UTF_8));
        return String.format("%x", new BigInteger(1, digest.digest()));
    }

    public static String Sha256(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(message.getBytes(StandardCharsets.UTF_8));
        return String.format("%x", new BigInteger(1, digest.digest()));
    }

    public static String Sha512(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.reset();
        digest.update(message.getBytes(StandardCharsets.UTF_8));
        return String.format("%x", new BigInteger(1, digest.digest()));
    }
}
