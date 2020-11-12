package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.User;

public interface UserRepository extends FilterActiveCrudRepository<User> {

    Iterable<User> findAllByIsActiveTrue();
}
