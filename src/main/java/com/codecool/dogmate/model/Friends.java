package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity
public class Friends {

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

    public Friends(User relatingUser, User relatedUser, boolean isAccepted) {
        this.relatingUser = relatingUser;
        this.relatedUser = relatedUser;
        this.isAccepted = isAccepted;
    }

    public Friends() {
    }
}
