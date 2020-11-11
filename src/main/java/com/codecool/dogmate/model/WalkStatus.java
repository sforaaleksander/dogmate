package com.codecool.dogmate.model;

import javax.persistence.*;

@Entity
public class WalkStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private String name;

    WalkStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public WalkStatus() {
    }

    public enum WalkStatusEnum {
        PLANNED, CANCELLED, PAST, ONGOING;
    }
}
