package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Session;

public interface SessionRepository extends FilterActiveCrudRepository<Session> {

    Iterable<Session> findAllByIsActiveTrue();
}
