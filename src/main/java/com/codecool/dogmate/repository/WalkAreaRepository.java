package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.WalkArea;

import org.springframework.stereotype.Repository;

@Repository
public interface WalkAreaRepository extends FilterActiveCrudRepository<WalkArea, Long> {
    Iterable<WalkArea> findAllByIsActiveTrue();
}
