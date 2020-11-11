package com.codecool.dogmate.model;

public class WalkStatus {
//    PLANNED, CANCELLED, PAST, ONGOING

    private final Long id;
    private final String name;

    WalkStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
