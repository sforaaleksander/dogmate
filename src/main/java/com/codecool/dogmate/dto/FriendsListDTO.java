package com.codecool.dogmate.dto;

import java.util.Set;

public class FriendsListDTO {
    private Long id;
    private String name;
    private String img;
    private Set<DogsToFriendsListDTO> dogs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<DogsToFriendsListDTO> getDogs() {
        return dogs;
    }

    public void setDogs(Set<DogsToFriendsListDTO> dogs) {
        this.dogs = dogs;
    }
}
