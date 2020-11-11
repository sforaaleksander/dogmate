package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(nullable = false)
    private String password;

    private String about;

    @Lob
    private Blob avatar;

    @ManyToOne
    private UserType userType;

    @ManyToMany
    private Set<Dog> dogs;

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

    public User() {}
}
