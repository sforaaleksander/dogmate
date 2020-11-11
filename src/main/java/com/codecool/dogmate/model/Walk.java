package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Walk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Timestamp startTime;

    @Column(nullable = false)
    @ManyToOne
    private Location location;

    @Column(nullable = false)
    @ManyToOne
    private WalkStatus walkStatus;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isVisible = true;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    public Walk(Long id, Integer duration, Timestamp startTime, Location location, WalkStatus walkStatus) {
        this.id = id;
        this.duration = duration;
        this.startTime = startTime;
        this.location = location;
        this.walkStatus = walkStatus;
    }

    public Walk() {

    }
}