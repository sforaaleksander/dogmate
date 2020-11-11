package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "breeds")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public Breed(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Breed() {}
}
