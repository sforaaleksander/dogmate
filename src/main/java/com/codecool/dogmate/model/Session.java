package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "sessions")
public class Session implements Indexable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Timestamp startTime;

    @Column(nullable = false)
    private Timestamp endTime;

    @OneToOne
    private LoginAttempt loginAttempt;

    public Session(String id, User user, Timestamp startTime, Timestamp endTime, LoginAttempt loginAttempt) {
        this.id = id;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.loginAttempt = loginAttempt;
    }

    public Session() {}

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
