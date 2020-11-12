package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Dog;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends FilterActiveCrudRepository<Dog>{

    Iterable<Dog> findAllByIsActiveTrue();
}
