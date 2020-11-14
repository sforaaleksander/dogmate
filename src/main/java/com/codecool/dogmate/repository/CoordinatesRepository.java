package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Coordinates;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepository extends CrudRepository<Coordinates, Long> {
}
