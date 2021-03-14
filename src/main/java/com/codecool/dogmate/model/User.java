package com.codecool.dogmate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.Set;

@Entity(name = "users")
public class User implements Indexable<Long>, Archivable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50)
    @NotNull
    private String name;

    @Column(nullable = false, length = 50)
    @Size(min = 3, max = 50)
    @NotNull
    @Email
    private String email;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(nullable = false)
    @Min(5)
    @NotNull
    private String password;

    private String about;

    @Lob
    private Blob avatar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "id")
    private UserType userType;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dog_id"))
    @JsonIgnoreProperties(value = {"id", "walks"})
    private Set<Dog> dogs;

    public User(String name, String email, String password, String about, Blob avatar, UserType userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
        this.avatar = avatar;
        this.userType = userType;
    }

    public User() {
    }

    public Set<Dog> getDogs() {
        return dogs;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public boolean isActive() {
        return isActive;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }

    public String getEmail() {
        return email;
    }

    public String getAbout() {
        return about;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public Boolean getActive() {
        return isActive;
    }

    @Override
    public void setActive(Boolean active) {
        this.isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
