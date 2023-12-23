package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.common.domain.validationErrors.MaxLengthError;
import com.example.user.common.domain.validationErrors.MinLengthError;
import com.example.user.common.domain.validationErrors.ValueIsNotValidError;
import com.example.user.common.domain.validationErrors.ValueIsRequiredError;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

public class Password extends ValueObject {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 128;

    private String value;

    public Password(String value) {
        if (Strings.isBlank(value)) {
            throw new ValueIsRequiredError();
        }

        String password = value.trim();

        if (password.length() < MIN_LENGTH) {
            throw new MinLengthError(MIN_LENGTH);
        }

        if (password.length() > MAX_LENGTH) {
            throw new MaxLengthError(MAX_LENGTH);
        }

        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
            throw new ValueIsNotValidError();
        }

        this.value = password;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(value);
    }

    public String getValue() {
        return value;
    }
}
