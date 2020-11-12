package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Coordinates;

public interface CoordinatesRepository extends FilterActiveCrudRepository<Coordinates> {

    Iterable<Coordinates> findAllByIsActiveTrue();
}
