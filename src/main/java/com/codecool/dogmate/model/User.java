package com.codecool.dogmate.model;

import java.sql.Blob;

public class User {

    private final Long id;
    private final String name;
    private final String email;
    private final boolean isActive;
    private final String password;
    private final String about;
    private final Blob avatar;
    private final UserType userType;
//    @ManyToMany
//    private final Dog dog;

    public User(Long id, String name, String email, boolean isActive, String password, String about, Blob avatar, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isActive = isActive;
        this.password = password;
        this.about = about;
        this.avatar = avatar;
        this.userType = userType;
    }
}
