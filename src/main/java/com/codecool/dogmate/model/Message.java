package com.codecool.dogmate.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User recipient;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp time = new Timestamp(new java.util.Date().getTime()); //TODO delegate to database?

    public Message(User sender, User recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public Message() {}
}
