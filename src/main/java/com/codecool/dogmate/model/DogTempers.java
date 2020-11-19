package com.codecool.dogmate.model;

import java.util.stream.Stream;

public enum DogTempers{
    AGGRESSIVE(1L),
    DOMINANT(2L),
    EASY_GOING(3L),
    SUBMISSIVE(4L),
    DUPA(5L);

    private Long id;

    DogTempers(Long id) {
        this.id = id;
    }

    DogTempers() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static DogTempers of(long id) {
        return Stream.of(DogTempers.values())
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
