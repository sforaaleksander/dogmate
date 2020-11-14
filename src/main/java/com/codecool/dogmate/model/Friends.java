package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity
public class Friends implements Indexable<FriendsKey> {

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

    @Override
    public void setId(FriendsKey id) {
        this.id = id;
    }

    @Override
    public FriendsKey getId() {
        return id;
    }

    public User getRelatingUser() {
        return relatingUser;
    }

    public void setRelatingUser(User relatingUser) {
        this.relatingUser = relatingUser;
    }

    public User getRelatedUser() {
        return relatedUser;
    }

    public void setRelatedUser(User relatedUser) {
        this.relatedUser = relatedUser;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
