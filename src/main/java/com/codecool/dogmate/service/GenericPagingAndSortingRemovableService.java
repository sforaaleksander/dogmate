package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.repository.FilterActivePagingAndSortingRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public abstract class GenericPagingAndSortingRemovableService<T extends Indexable<ID> & Archivable, ID> extends GenericPagingAndSortingService<T, ID> {
    protected final FilterActivePagingAndSortingRepository<T, ID> repository;

    public GenericPagingAndSortingRemovableService(FilterActivePagingAndSortingRepository<T, ID> repository) {
        super(repository);
        this.repository = repository;
    }

    public void removeById(ID id) {
        T t = getById(id);
        t.setActive(false);
        repository.save(t);
    }

    @Override
    public Iterable<T> getAllPagedAndSorted(Integer page, Integer size, String[] sortBy) {
        return repository.findAllByIsActiveTrue(PageRequest.of(page, size, Sort.by(sortBy))).getContent();
    }

    @Override
    public T getById(ID id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent() && optional.get().getActive()) return optional.get();
        throw new NotFoundException();
    }
}
