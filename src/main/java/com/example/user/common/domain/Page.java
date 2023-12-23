package com.example.user.common.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Page<T> extends ValueObject {
    private List<T> items;
    private long count;

    public Page(List<T> items, long count) {
        this.items = items;
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public long getCount() {
        return count;
    }

    @Override
    protected Iterable<Object> getEqualityComponents() {
        return Arrays.asList(items, count);
    }

    public static Page Empty() {
        return new Page(new ArrayList(), 0);
    }
}
