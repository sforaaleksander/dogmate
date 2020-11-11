package com.codecool.dogmate.model;

import java.sql.Timestamp;

public class Session {

    private final String id;
    private final User user;
    private final Timestamp startDate;

    public Session(String id, User user, Timestamp startDate) {
        this.id = id;
        this.user = user;
        this.startDate = startDate;
    }
}
