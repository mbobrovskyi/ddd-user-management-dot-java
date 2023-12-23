package com.example.user.common.domain;

import java.util.UUID;

public class Session {
    private UUID id;
    private long userId;
    private String email;

    public Session(long userId, String email) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return this.id == ((Session) obj).id;
    }

    @Override
    public int hashCode() {
        return (getClass().getName() + this.id).hashCode();
    }
}
