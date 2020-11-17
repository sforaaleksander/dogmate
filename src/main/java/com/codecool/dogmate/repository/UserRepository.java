package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends FilterActivePagingAndSortingRepository<User, Long> {
    User findByEmail(String email);
}
