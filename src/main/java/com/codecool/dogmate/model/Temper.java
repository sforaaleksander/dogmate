package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity
public class Temper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Temper(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Temper() {}
}
