package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Temper;

public interface TemperRepository extends FilterActiveCrudRepository<Temper> {

    Iterable<Temper> findAllByIsActiveTrue();
}
