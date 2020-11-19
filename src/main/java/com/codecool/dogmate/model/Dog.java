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
    private boolean isMale;

    @Column(nullable = false)
    @CreatedDate
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(columnDefinition = "boolean default true")
    @NotNull
    private boolean isDefaultDog = true;

    @ManyToOne
    @NotNull
    @JsonIgnoreProperties(value = "id")
    private Breed breed;

    @ManyToOne
    @NotNull
    @JsonIgnoreProperties(value = "id")
    private Temper temper;

    @Column(columnDefinition = "boolean default false", nullable = false)
    private Boolean isNeutered = false;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "dog_id"),
            inverseJoinColumns = @JoinColumn(name = "walk_id"))
    private Set<Walk> walks;

    public Dog(String name, boolean isMale, Date dateOfBirth, Breed breed, Temper temper, Boolean isNeutered) {
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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isDefaultDog() {
        return isDefaultDog;
    }

    public void setDefaultDog(boolean defaultDog) {
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

    public boolean isNeutered() {
        return isNeutered;
    }

    public void setNeutered(boolean neutered) {
        isNeutered = neutered;
    }
}
