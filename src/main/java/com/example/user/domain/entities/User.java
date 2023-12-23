package com.example.user.domain.entities;

import com.example.user.common.domain.Entity;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.FirstName;
import com.example.user.domain.valueObjects.LastName;

import java.time.LocalDateTime;

public class User extends Entity {
    private Email email;
    private FirstName firstName;
    private LastName lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(Email email, FirstName firstName, LastName lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public User(long id, Email email, FirstName firstName, LastName lastName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
