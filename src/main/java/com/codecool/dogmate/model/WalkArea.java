package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "walk_areas")
public class WalkArea implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    public WalkArea(String name) {
        this.name = name;
    }

    public WalkArea() {
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
