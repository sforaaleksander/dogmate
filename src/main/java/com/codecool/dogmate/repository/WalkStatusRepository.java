package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.WalkStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkStatusRepository extends PagingAndSortingRepository<WalkStatus, Long> {
}
