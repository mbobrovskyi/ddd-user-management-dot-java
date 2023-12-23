package com.example.user.common.domain;

public abstract class Entity {
    private long id;

    public Entity() {}

    public Entity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return this.id == ((Entity) obj).id;
    }

    @Override
    public int hashCode() {
        return (getClass().toString() + id).hashCode();
    }
}
