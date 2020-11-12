package com.codecool.dogmate.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "walk_areas")
public class WalkArea {

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

    public WalkArea() {}
}
