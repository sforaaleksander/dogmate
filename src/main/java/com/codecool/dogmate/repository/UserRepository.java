package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.User;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends FilterActivePagingAndSortingRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
