package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.WalkCoordinates;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkCoordinatesRepository extends PagingAndSortingRepository<WalkCoordinates, Long> {
}
