package com.codecool.dogmate.model;

import java.sql.Timestamp;

public class LoginAttempt {

    private final Long id;
    private final User user;
    private final Timestamp time;
    private final boolean isSuccessful;
    private final String ip;

    public LoginAttempt(Long id, User user, Timestamp time, boolean isSuccessful, String ip) {
        this.id = id;
        this.user = user;
        this.time = time;
        this.isSuccessful = isSuccessful;
        this.ip = ip;
    }
}
