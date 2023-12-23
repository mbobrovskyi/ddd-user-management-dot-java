package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.domain.entities.User;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Token extends ValueObject {
    public static final int TOKEN_LENGTH = 32;
    public static final long TTL = 30 * 24 * 60 * 60;

    private String token;
    private long expInt;
    private LocalDateTime expTime;
    private User user;

    public Token(User user) {
        this.user = user;

        SecureRandom rnd = new SecureRandom();
        byte[] token = new byte[TOKEN_LENGTH];
        rnd.nextBytes(token);

        this.token = token.toString();
        this.expInt = TTL;
        this.expTime = LocalDateTime.now().plusSeconds(TTL);
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(token);
    }

    public String getToken() {
        return token;
    }

    public long getExpInt() {
        return expInt;
    }

    public LocalDateTime getExpTime() {
        return expTime;
    }

}
