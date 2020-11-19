package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "walk_statuses")
public class WalkStatus implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    WalkStatus(String name) {
        this.name = name;
    }

    public WalkStatus() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public enum WalkStatusEnum {
        PLANNED, CANCELLED, PAST, ONGOING
    }

    public String getName() {
        return name;
    }
}
