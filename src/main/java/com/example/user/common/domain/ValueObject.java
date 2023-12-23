package com.example.user.common.domain;

import java.util.stream.StreamSupport;

public abstract class ValueObject {
    protected abstract Iterable<Object> getEqualityComponents();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return ((ValueObject) obj)
                .getEqualityComponents()
                .equals(this.getEqualityComponents());
    }

    @Override
    public int hashCode() {
        return (int) StreamSupport
                .stream(getEqualityComponents().spliterator(), false)
                .reduce(0, (accum, i) -> ((int)accum) ^ i.hashCode());
    }
}
