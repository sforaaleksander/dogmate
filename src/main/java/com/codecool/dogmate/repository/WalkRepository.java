package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Walk;

import org.springframework.stereotype.Repository;

@Repository
public interface WalkRepository extends FilterActiveCrudRepository<Walk, Long> {
    Iterable<Walk> findAllByIsActiveTrue();
}
