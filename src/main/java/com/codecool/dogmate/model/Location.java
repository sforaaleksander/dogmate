package com.codecool.dogmate.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal longitude;

    @Column(nullable = false)
    private BigDecimal latitude;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    public Location(Long id, String name, BigDecimal longitude, BigDecimal latitude) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location() {}
}
