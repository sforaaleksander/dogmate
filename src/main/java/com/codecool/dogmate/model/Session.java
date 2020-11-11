package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Timestamp startDate;

    public Session(String id, User user, Timestamp startDate) {
        this.id = id;
        this.user = user;
        this.startDate = startDate;
    }

    public Session() {}
}
