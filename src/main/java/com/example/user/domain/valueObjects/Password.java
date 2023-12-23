package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.common.errors.Error;
import com.example.user.common.errors.Errors;
import com.example.user.common.result.Result;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

public class Password extends ValueObject {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 128;

    private String value;

    private Password(String value) {
        this.value = value;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(value);
    }

    public String getValue() {
        return value;
    }

    public static Result<Password, Error> create(String value) {
        if (Strings.isBlank(value)) {
            return Result.Error(Errors.Global.ValueIsRequiredError());
        }

        String password = value.trim();

        if (password.length() < MIN_LENGTH) {
            return Result.Error(Errors.Global.MinLengthError(MIN_LENGTH));
        }

        if (password.length() > MAX_LENGTH) {
            return Result.Error(Errors.Global.MaxLengthError(MAX_LENGTH));
        }

        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
            return Result.Error(Errors.Global.ValueIsNotValidError());
        }

        return Result.Success(new Password(value));
    }
}
