package com.example.user.common.result;

public class Result<TResult, TError> {
    private boolean isSuccess;
    private TResult value;
    private TError error;

    private Result(boolean isSuccess, TResult value, TError error) {
        this.isSuccess = isSuccess;
        this.value = value;
        this.error = error;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public boolean isFailure() {
        return !this.isSuccess;
    }

    public TResult getValue() {
        return value;
    }

    public TError getError() {
        return error;
    }

    public static <TValue> Result Success(TValue value) {
        return new Result(true, value, null);
    }

    public static <TError> Result Error(TError error) {
        return new Result(false, error, null);
    }
}
