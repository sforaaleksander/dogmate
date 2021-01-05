package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Indexable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class GenericPagingAndSortingService<T extends Indexable<ID>, ID> extends GenericService<T, ID> {
    protected final PagingAndSortingRepository<T, ID> repository;

    public GenericPagingAndSortingService(PagingAndSortingRepository<T, ID> repository) {
        super(repository);
        this.repository = repository;
    }

    public Iterable<T> getAll(Integer page, Integer size, String[] sortBy) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(sortBy))).getContent();
    }
}
