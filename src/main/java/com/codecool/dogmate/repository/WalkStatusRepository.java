package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.WalkStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkStatusRepository extends CrudRepository<WalkStatus, Long> {
}
