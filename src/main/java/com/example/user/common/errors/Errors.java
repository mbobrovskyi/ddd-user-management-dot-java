package com.example.user.common.errors;

public final class Errors {
    public final class Global {
        public static ValidationError ValueIsRequiredError() {
            return new ValidationError("ValueIsRequiredError", "Value is required.");
        }

        public static ValidationError MinLengthError(int minLength) {
            return new ValidationError("MinLengthError", String.format("Min length is %d.", minLength));
        }

        public static ValidationError MaxLengthError(int maxLength) {
            return new ValidationError("MaxLengthError", String.format("Max length is %d.", maxLength));
        }

        public static ValidationError ValueIsNotValidError() {
            return new ValidationError("ValueIsNotValidError", "Value is not valid.");
        }
    }
}
