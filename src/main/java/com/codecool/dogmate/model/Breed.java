package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "breeds")
public class Breed implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public Breed(String name) {
        this.name = name;
    }

    public Breed() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
