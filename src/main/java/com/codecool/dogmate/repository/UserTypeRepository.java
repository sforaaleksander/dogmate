package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.UserType;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends PagingAndSortingRepository<UserType, Long> {
}
