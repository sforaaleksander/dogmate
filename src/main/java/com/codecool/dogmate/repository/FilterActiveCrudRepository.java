package com.codecool.dogmate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FilterActiveCrudRepository<T, ID> extends CrudRepository<T, ID> {
    Iterable<T> findAllByIsActiveTrue();
}
