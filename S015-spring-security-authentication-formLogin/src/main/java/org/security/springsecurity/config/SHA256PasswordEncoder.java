package org.security.springsecurity.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return hashWithSHA256(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return hashWithSHA256(rawPassword.toString()).equals(encodedPassword);
    }

    private String hashWithSHA256(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digested = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : digested) {
                hexString.append(Integer.toHexString(0xff & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
