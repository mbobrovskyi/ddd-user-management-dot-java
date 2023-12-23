package com.example.user.common.domain.validationErrors;

import com.example.user.common.errors.ValidationError;

public class ValueIsNotValidError extends ValidationError {
    public ValueIsNotValidError() {
        super("Value is not valid.");
    }
}
