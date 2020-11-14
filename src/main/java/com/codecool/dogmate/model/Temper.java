package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "tempers")
public class Temper implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public Temper(String name) {
        this.name = name;
    }

    public Temper() {}

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
