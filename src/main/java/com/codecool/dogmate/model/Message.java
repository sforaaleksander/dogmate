package com.codecool.dogmate.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    private User sender;

    @Column(nullable = false)
    @ManyToOne
    private User recipient;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp time = new Timestamp(new java.util.Date().getTime()); //TODO delegate to database?

    public Message(Long id, User sender, User recipient, String content) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public Message() {}
}
