package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "sessions")
public class Session {

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

    public Session() {}
}
