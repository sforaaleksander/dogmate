package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "login_attempts")
public class LoginAttempt implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Timestamp time;

    @Column(nullable = false)
    private boolean isSuccessful;

    @Column(nullable = false, length = 45)
    private String ip;

    public LoginAttempt(User user, Timestamp time, boolean isSuccessful, String ip) {
        this.user = user;
        this.time = time;
        this.isSuccessful = isSuccessful;
        this.ip = ip;
    }

    public LoginAttempt() {}

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
