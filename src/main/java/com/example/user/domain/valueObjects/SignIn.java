package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;

import java.util.Arrays;

public class SignIn extends ValueObject {
    private Email email;
    private Password password;

    public SignIn(Email email, Password password) {
        this.email = email;
        this.password = password;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList();
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }
}
