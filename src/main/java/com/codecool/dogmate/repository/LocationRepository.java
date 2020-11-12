package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Location;

public interface LocationRepository extends FilterActiveCrudRepository<Location> {

    Iterable<Location> findAllByIsActiveTrue();
}
