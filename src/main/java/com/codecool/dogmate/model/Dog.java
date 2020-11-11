package com.codecool.dogmate.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean isMale;

    @Column(nullable = false)
    @CreationTimestamp
    private Date dateOfBirth;

    @Column(columnDefinition = "boolean default true")
    private boolean isDefaultDog = true;

    @ManyToOne
    private Breed breed;

    @ManyToOne
    private Temper temper;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    public Dog(Long id, String name, boolean isMale, Date dateOfBirth, boolean isDefaultDog, Breed breed, Temper temper) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
        this.dateOfBirth = dateOfBirth;
        this.isDefaultDog = isDefaultDog;
        this.breed = breed;
        this.temper = temper;
    }

    public Dog() {}
}
