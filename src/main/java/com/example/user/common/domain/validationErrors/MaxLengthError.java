package com.example.user.common.domain.validationErrors;

import com.example.user.common.errors.ValidationError;

public class MaxLengthError extends ValidationError {
    public MaxLengthError(long maxLength) {
        super(String.format("Max length is %d.", maxLength));
    }
}
