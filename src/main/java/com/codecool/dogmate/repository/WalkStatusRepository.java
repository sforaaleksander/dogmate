package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.WalkStatus;

public interface WalkStatusRepository extends FilterActiveCrudRepository<WalkStatus> {

    Iterable<WalkStatus> findAllByIsActiveTrue();
}
