package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.LoginAttempt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAttemptRepository extends CrudRepository<LoginAttempt, Long> {
}
