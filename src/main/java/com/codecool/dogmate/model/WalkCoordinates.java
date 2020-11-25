package com.codecool.dogmate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class WalkCoordinates implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JsonIgnoreProperties(value = "id")
    private Coordinates coordinates;

    @ManyToOne
    @NotNull
    @JsonIgnoreProperties(value = "id")
    private WalkArea walkArea;

    public WalkCoordinates(Coordinates coordinates, WalkArea walkArea) {
        this.coordinates = coordinates;
        this.walkArea = walkArea;
    }

    public WalkCoordinates() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public WalkArea getWalkArea() {
        return walkArea;
    }

    public void setWalkArea(WalkArea walkArea) {
        this.walkArea = walkArea;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
