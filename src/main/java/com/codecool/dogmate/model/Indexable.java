package com.codecool.dogmate.model;

public interface Indexable<T> {
    void setId(T id);
    T getId();
}
