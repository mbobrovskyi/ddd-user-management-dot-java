package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Arrays;

public class HashPassword extends ValueObject {
    private static final int LOG_ROUNDS = 13;

    private String value;

    public HashPassword(String value) {
        this.value = value;
    }

    public HashPassword(Password password) {
        this.value = BCrypt.hashpw(password.getValue(), BCrypt.gensalt(LOG_ROUNDS));
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(value);
    }

    public String getValue() {
        return value;
    }

    public boolean compare(Password password) {
        return BCrypt.checkpw(password.getValue(), this.getValue());
    }
}
