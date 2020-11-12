package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, String> {
}
