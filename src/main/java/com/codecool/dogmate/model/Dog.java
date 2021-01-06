package com.codecool.dogmate.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity(name = "dogs")
public class Dog implements Indexable<Long>, Archivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @Size(min = 3, max = 50)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private Boolean isMale;

    @Column(nullable = false)
    @CreatedDate
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(columnDefinition = "Boolean default true")
    @NotNull
    private Boolean isDefaultDog = true;

    @ManyToOne
    @NotNull
//    @JsonIgnoreProperties(value = "id")
    private Breed breed;

    @ManyToOne
    @NotNull
//    @JsonIgnoreProperties(value = "id")
    private Temper temper;

    @Column(columnDefinition = "Boolean default false", nullable = false)
    private Boolean isNeutered = false;

    @Column(columnDefinition = "Boolean default true", nullable = false)
    private Boolean isActive = true;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "dog_id"),
            inverseJoinColumns = @JoinColumn(name = "walk_id"))
    private Set<Walk> walks;

    public Dog(String name, Boolean isMale, Date dateOfBirth, Breed breed, Temper temper, Boolean isNeutered) {
        this.name = name;
        this.isMale = isMale;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.temper = temper;
        this.isNeutered = isNeutered;
    }

    public Dog() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean isDefaultDog() {
        return isDefaultDog;
    }

    public void setDefaultDog(Boolean defaultDog) {
        isDefaultDog = defaultDog;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Temper getTemper() {
        return temper;
    }

    public void setTemper(Temper temper) {
        this.temper = temper;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Set<Walk> getWalks() {
        return walks;
    }

    public void setWalks(Set<Walk> walks) {
        this.walks = walks;
    }

    public Boolean isNeutered() {
        return isNeutered;
    }

    public void setNeutered(Boolean neutered) {
        isNeutered = neutered;
    }
}
