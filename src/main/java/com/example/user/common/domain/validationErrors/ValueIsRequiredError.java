package com.example.user.common.domain.validationErrors;

import com.example.user.common.errors.ValidationError;

public class ValueIsRequiredError extends ValidationError {
    public ValueIsRequiredError() {
        super("Value is required.");
    }
}
