package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User relatingUser;

    @ManyToOne
    private User relatedUser;

    @Column(columnDefinition = "boolean default false")
    private boolean isAccepted = false;

    public Friends(User relatingUser, User relatedUser, boolean isAccepted) {
        this.relatingUser = relatingUser;
        this.relatedUser = relatedUser;
        this.isAccepted = isAccepted;
    }

    public Friends() {}
}
