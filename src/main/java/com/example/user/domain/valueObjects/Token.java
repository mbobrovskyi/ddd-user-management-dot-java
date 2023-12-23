package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;

public class Token extends ValueObject {
    public static final int TOKEN_LENGTH = 32;
    public static final long TTL = 30 * 24 * 60 * 60;

    private String token;
    private long expiresIn;
    private LocalDateTime expiresAt;

    public Token() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[TOKEN_LENGTH];
        secureRandom.nextBytes(token);

        this.token = Base64.getUrlEncoder().withoutPadding().encodeToString(token);
        this.expiresIn = TTL;
        this.expiresAt = LocalDateTime.now().plusSeconds(TTL);
    }

    public Token(String token) {
        this.token = token;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(token);
    }

    public String getToken() {
        return token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}
