package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "tempers")
public class Temper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public Temper(String name) {
        this.name = name;
    }

    public Temper() {}
}
