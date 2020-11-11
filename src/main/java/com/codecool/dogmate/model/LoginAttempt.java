package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "login_attempts")
public class LoginAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Timestamp time;

    @Column(nullable = false)
    private boolean isSuccessful;

    @Column(nullable = false)
    private String ip;

    public LoginAttempt(Long id, User user, Timestamp time, boolean isSuccessful, String ip) {
        this.id = id;
        this.user = user;
        this.time = time;
        this.isSuccessful = isSuccessful;
        this.ip = ip;
    }

    public LoginAttempt() {}
}
