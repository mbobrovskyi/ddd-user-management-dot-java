package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.common.result.Result;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Arrays;

public class HashPassword extends ValueObject {
    private static final int LOG_ROUNDS = 13;

    private String value;

    private HashPassword(String password) {
        this.value = BCrypt.hashpw(password, BCrypt.gensalt(LOG_ROUNDS));
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

    public static Result<HashPassword, Error> create(String value) {
        return Result.Success(new HashPassword(value));
    }

}
