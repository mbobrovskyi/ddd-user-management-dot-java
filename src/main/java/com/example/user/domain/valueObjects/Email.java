package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.common.domain.validationErrors.MaxLengthError;
import com.example.user.common.domain.validationErrors.ValueIsNotValidError;
import com.example.user.common.domain.validationErrors.ValueIsRequiredError;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

public class Email extends ValueObject {
    public static final int MAX_LENGTH = 320;

    private String value;

    public Email(String value) {
        if (Strings.isBlank(value)) {
            throw new ValueIsRequiredError();
        }

        String email = value.trim();

        if (email.length() > MAX_LENGTH) {
            throw new MaxLengthError(MAX_LENGTH);
        }

        if (!email.matches("^(.+)@(.+)$")) {
            throw new ValueIsNotValidError();
        }

        this.value = email;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(value);
    }

    public String getValue() {
        return value;
    }

}
