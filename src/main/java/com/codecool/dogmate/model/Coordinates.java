package com.codecool.dogmate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Coordinates implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 9, scale = 6)
    @NotNull
    private BigDecimal longitude;

    @Column(nullable = false, precision = 8, scale = 6)
    @NotNull
    private BigDecimal latitude;

    @ManyToOne
    @NotNull
    @JsonIgnoreProperties(value = "id")
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

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public WalkArea getWalkArea() {
        return walkArea;
    }

    public void setWalkArea(WalkArea walkArea) {
        this.walkArea = walkArea;
    }
}
