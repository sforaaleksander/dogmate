package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Indexable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public abstract class GenericService<T extends Indexable<ID>, ID> {
    protected final PagingAndSortingRepository<T, ID> repository;

    public GenericService(PagingAndSortingRepository<T, ID> repository) {
        this.repository = repository;
    }

    public Iterable<T> getAll(Integer page, Integer size, String[] sortBy) {
        return repository.findAll(PageRequest.of(page, size, Sort.by(sortBy))).getContent();
    }

    public T getById(ID id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) return optional.get();
        throw new NotFoundException();
    }

    public void update(T newObject, ID id) {
        if (!repository.existsById(id)) throw new NotFoundException();

        newObject.setId(id);
        repository.save(newObject);
    }

    public void insert(T object) {
        object.setId(null);
        repository.save(object);
    }
}
