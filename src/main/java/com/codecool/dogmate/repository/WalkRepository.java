package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Walk;

public interface WalkRepository extends FilterActiveCrudRepository<Walk> {
    Iterable<Walk> findAllByIsActiveTrue();
}
