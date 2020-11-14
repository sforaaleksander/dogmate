package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Temper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperRepository extends CrudRepository<Temper, Long> {
}
