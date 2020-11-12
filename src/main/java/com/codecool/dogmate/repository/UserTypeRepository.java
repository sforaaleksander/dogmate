package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.UserType;

public interface UserTypeRepository extends FilterActiveCrudRepository<UserType> {

    Iterable<UserType> findAllByIsActiveTrue();
}
