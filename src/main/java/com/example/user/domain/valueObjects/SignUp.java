package com.example.user.domain.valueObjects;

import com.example.user.common.domain.ValueObject;

import java.util.Arrays;

public class SignUp extends ValueObject {

    private Email email;
    private FirstName firstName;
    private LastName lastName;
    private Password password;

    public SignUp(Email email, FirstName firstName, LastName lastName, Password password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(email, firstName, lastName, password);
    }

    public Email getEmail() {
        return email;
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public Password getPassword() {
        return password;
    }
}
