package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "walks")
public class Walk implements Indexable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private Timestamp startTime;

    @ManyToOne
    private WalkArea walkArea;

    @ManyToOne
    private WalkStatus walkStatus;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isVisible = true;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    @ManyToOne
    private User user;

    public Walk(Integer duration, Timestamp startTime, WalkArea walkArea, WalkStatus walkStatus) {
        this.duration = duration;
        this.startTime = startTime;
        this.walkArea = walkArea;
        this.walkStatus = walkStatus;
    }

    public Walk() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
