package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.LoginAttempt;

public interface LoginAttemptRepository extends FilterActiveCrudRepository<LoginAttempt> {

    Iterable<LoginAttempt> findAllByIsActiveTrue();
}
