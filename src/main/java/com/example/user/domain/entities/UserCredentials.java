package com.example.user.domain.entities;

import com.example.user.common.domain.Entity;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.HashPassword;

public class UserCredentials extends Entity {
    private Email email;
    private HashPassword hashPassword;

    public UserCredentials(long id, Email email, HashPassword hashPassword) {
        super(id);
        this.email = email;
        this.hashPassword = hashPassword;
    }

    public Email getEmail() {
        return email;
    }

    public HashPassword getHashPassword() {
        return hashPassword;
    }
}
