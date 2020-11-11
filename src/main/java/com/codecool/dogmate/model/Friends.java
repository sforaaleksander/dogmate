package com.codecool.dogmate.model;

public class Friends {

    private final User relatingUser;
    private final User relatedUser;
    private final boolean isAccepted;

    public Friends(User relatingUser, User relatedUser, boolean isAccepted) {
        this.relatingUser = relatingUser;
        this.relatedUser = relatedUser;
        this.isAccepted = isAccepted;
    }
}
