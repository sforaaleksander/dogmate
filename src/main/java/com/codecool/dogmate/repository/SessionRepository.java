package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Session;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends PagingAndSortingRepository<Session, String> {
}
