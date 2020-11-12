package com.codecool.dogmate.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity(name = "users")
public class User implements Indexable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(nullable = false)
    private String password;

    private String about;

    @Lob
    private Blob avatar;

    @ManyToOne
    private UserType userType;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dog_id"))
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

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
