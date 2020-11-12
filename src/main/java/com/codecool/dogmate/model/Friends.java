package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity
public class Friends implements Indexable {

    @EmbeddedId
    FriendsKey id;

    @ManyToOne
    @MapsId("relatingUserId")
    @JoinColumn(name = "relating_user_id")
    private User relatingUser;

    @ManyToOne
    @MapsId("relatedUserId")
    @JoinColumn(name = "related_user_id")
    private User relatedUser;

    @Column(columnDefinition = "boolean default false")
    private boolean isAccepted = false;

    public Friends(User relatingUser, User relatedUser) {
        this.relatingUser = relatingUser;
        this.relatedUser = relatedUser;
    }

    public Friends() {
    }

}
