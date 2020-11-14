package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "user_types")
public class UserType implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    public UserType(String name) {
        this.name = name;
    }

    public UserType() {
    }

    public enum WalkStatusEnum {
        ADMIN, USER
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
