package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Breed;

public interface BreedRepository extends FilterActiveCrudRepository<Breed> {

    Iterable<Breed> findAllByIsActiveTrue();
}
