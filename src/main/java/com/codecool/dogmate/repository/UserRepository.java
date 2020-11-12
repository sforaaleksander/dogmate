package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends FilterActiveCrudRepository<User, Long> {

    Iterable<User> findAllByIsActiveTrue();
}
