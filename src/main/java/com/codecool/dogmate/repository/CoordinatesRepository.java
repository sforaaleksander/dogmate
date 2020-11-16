package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Coordinates;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepository extends PagingAndSortingRepository<Coordinates, Long> {
}
