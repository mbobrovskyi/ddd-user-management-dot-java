package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;
import com.example.user.common.errors.Errors;
import com.example.user.common.result.Result;
import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;

public class LastName extends ValueObject {
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 64;

    private String value;

    private LastName(String value) {
        this.value = value;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(value);
    }

    public String getValue() {
        return this.value;
    }

    public static Result<LastName, Error> create(String value) {
        if (Strings.isBlank(value)) {
            return Result.Error(Errors.Global.ValueIsRequiredError());
        }

        String lastName = value.trim();

        if (lastName.length() > MAX_LENGTH) {
            return Result.Error(Errors.Global.MaxLengthError(MAX_LENGTH));
        }

        return Result.Success(new LastName(value));
    }
}
