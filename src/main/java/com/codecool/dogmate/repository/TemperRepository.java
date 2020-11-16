package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Temper;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperRepository extends PagingAndSortingRepository<Temper, Long> {
}
