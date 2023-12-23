package com.example.user.common.domain;

public abstract class AggregateRoot extends Entity {
    public AggregateRoot() {}

    public AggregateRoot(long id) {
        super(id);
    }
}
