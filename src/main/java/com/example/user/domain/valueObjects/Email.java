package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.common.errors.Error;
import com.example.user.common.errors.Errors;
import com.example.user.common.result.Result;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

public class Email extends ValueObject {
    public static final int MAX_LENGTH = 320;

    private String value;

    private Email(String value) {
        this.value = value;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(value);
    }

    public String getValue() {
        return value;
    }

    public static Result<Email, Error> create(String value) {
        if (Strings.isBlank(value)) {
            return Result.Error(Errors.Global.ValueIsRequiredError());
        }

        String email = value.trim();

        if (email.length() > MAX_LENGTH) {
            return Result.Error(Errors.Global.MaxLengthError(MAX_LENGTH));
        }

        if (!email.matches("^(.+)@(.+)$")) {
            return Result.Error(Errors.Global.ValueIsNotValidError());
        }

        return Result.Success(new Email(value));
    }
}
