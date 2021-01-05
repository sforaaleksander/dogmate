package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Breed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends CrudRepository<Breed, Long> {
}
