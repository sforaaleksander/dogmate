package com.codecool.dogmate.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity(name = "walks")
public class Walk implements Indexable<Long>, Archivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private Integer duration;

    @Column(nullable = false)
    @NotNull
    private Timestamp startTime;

    @ManyToOne
    @NotNull
    private WalkArea walkArea;

    @ManyToOne
    @NotNull
    private WalkStatus walkStatus;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isVisible = true;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    @ManyToOne
    @NotNull
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

    public Integer getDuration() {
        return duration;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Boolean getVisible() {
        return isVisible;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public WalkArea getWalkArea() {
        return walkArea;
    }

    public void setWalkArea(WalkArea walkArea) {
        this.walkArea = walkArea;
    }

    public WalkStatus getWalkStatus() {
        return walkStatus;
    }

    public void setWalkStatus(WalkStatus walkStatus) {
        this.walkStatus = walkStatus;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    @Override
    public Boolean getActive() {
        return isActive;
    }

    @Override
    public void setActive(Boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
