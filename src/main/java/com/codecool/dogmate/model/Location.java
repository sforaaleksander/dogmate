package com.codecool.dogmate.model;

import java.math.BigDecimal;

public class Location {

    private final Long id;
    private final String name;
    private final BigDecimal longitude;
    private final BigDecimal latitude;

    public Location(Long id, String name, BigDecimal longitude, BigDecimal latitude) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
