package com.example.user.common.domain;

import java.util.UUID;

public class Session {
    private UUID id;
    private long userId;

    public Session(long userId) {
        this.id = UUID.randomUUID();
        this.userId = userId;
    }

    public Session(UUID id, long userId) {
        this.id = id;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public long getUserId() {
        return userId;
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
