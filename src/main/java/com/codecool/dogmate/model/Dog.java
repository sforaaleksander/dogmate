package com.codecool.dogmate.model;

import java.util.Date;

public class Dog {

    private final Long id;
    private final String name;
    private final boolean isMale;
    private final Date dateOfBirth;
    private final boolean isDefaultDog;
    private final Breed breed;
    private final Temper temper;
//    @ManyToMany
//    private final User user;

    public Dog(Long id, String name, boolean isMale, Date dateOfBirth, boolean isDefaultDog, Breed breed, Temper temper) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
        this.dateOfBirth = dateOfBirth;
        this.isDefaultDog = isDefaultDog;
        this.breed = breed;
        this.temper = temper;
    }
}
