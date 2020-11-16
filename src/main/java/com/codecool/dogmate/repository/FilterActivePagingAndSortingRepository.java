package com.codecool.dogmate.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FilterActivePagingAndSortingRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
    Page<T> findAllByIsActiveTrue(Pageable pageable);
}
