package com.codecool.dogmate.model;

import java.sql.Timestamp;

public class Walk {

    private final Long id;
    private final Integer duration;
    private final Timestamp startTime;
    private final Location location;
    private final WalkStatus walkStatus;

    public Walk(Long id, Integer duration, Timestamp startTime, Location location, WalkStatus walkStatus) {
        this.id = id;
        this.duration = duration;
        this.startTime = startTime;
        this.location = location;
        this.walkStatus = walkStatus;
    }
}
