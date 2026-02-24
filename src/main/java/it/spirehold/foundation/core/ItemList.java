package com.waveinformatica.hello.foundation.core;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class ItemList<T> implements ListContainer<T> {
    private final List<T> items;

    public ItemList(List<T> items) {
        this.items = Collections.unmodifiableList(items);
    }

    protected ItemList() {
        this(List.of());
    }
}
