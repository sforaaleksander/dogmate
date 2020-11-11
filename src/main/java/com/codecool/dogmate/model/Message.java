package com.codecool.dogmate.model;

import java.sql.Timestamp;

public class Message {

    private final Long id;
    private final User sender;
    private final User recipient;
    private final String content;
    private final Timestamp time;

    public Message(Long id, User sender, User recipient, String content, Timestamp time) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.time = time;
    }
}
