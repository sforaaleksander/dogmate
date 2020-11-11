package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "user_types")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    public UserType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserType() {
    }

    public enum WalkStatusEnum {
        ADMIN, USER
    }
}
