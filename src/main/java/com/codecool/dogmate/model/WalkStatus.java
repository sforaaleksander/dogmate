package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity(name = "walk_statuses")
public class WalkStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    //@Enumerated(EnumType.ORDINAL)
    private String name;

    WalkStatus(String name) {
        this.name = name;
    }

    public WalkStatus() {
    }

    public enum WalkStatusEnum {
        PLANNED, CANCELLED, PAST, ONGOING;
    }
}
