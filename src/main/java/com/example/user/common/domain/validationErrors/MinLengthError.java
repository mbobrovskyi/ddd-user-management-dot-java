package com.example.user.common.domain.validationErrors;

import com.example.user.common.errors.ValidationError;

public class MinLengthError extends ValidationError {
    public MinLengthError(long minLength) {
        super(String.format("Min length is %d.", minLength));
    }
}
