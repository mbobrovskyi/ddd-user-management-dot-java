package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.common.domain.validationErrors.MaxLengthError;
import com.example.user.common.domain.validationErrors.ValueIsRequiredError;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

public class LastName extends ValueObject {
    public static final int MAX_LENGTH = 64;

    private String value;

    public LastName(String value) {
        if (Strings.isBlank(value)) {
            throw new ValueIsRequiredError();
        }

        String lastName = value.trim();

        if (lastName.length() > MAX_LENGTH) {
            throw new MaxLengthError(MAX_LENGTH);
        }

        this.value = lastName;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(value);
    }

    public String getValue() {
        return this.value;
    }
}
