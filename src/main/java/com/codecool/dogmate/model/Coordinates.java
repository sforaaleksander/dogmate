package com.codecool.dogmate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Coordinates implements Indexable {
    @Id
    private Long id;

    @Column(nullable = false, precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(nullable = false, precision = 8, scale = 6)
    private BigDecimal latitude;

    @ManyToOne
    private WalkArea walkArea;

    public Coordinates(BigDecimal longitude, BigDecimal latitude, WalkArea walkArea) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.walkArea = walkArea;
    }

    public Coordinates() {
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
