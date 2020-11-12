package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.model.Validable;
import com.codecool.dogmate.repository.FilterActiveCrudRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class GenericService<T> {
    protected final CrudRepository<T, Long> repository;

    public GenericService(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }

    public Iterable<T> getAll() {
        return ((FilterActiveCrudRepository<T>) repository).findAllByIsActiveTrue();
    }

    private String getEntityName() {
        return this.getClass().getSimpleName().replace("Service", "");
    }

    public T getById(Long id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent() && ((Archivable) optional.get()).getIsActive()) return optional.get();
        throw new NotFoundException();
    }

    public void removeById(Long id) {
        T t = getById(id);

        ((Archivable) t).setIsActive(false);
        repository.save(t);
    }

    public void update(T newObject, Long id) {
        if (!repository.existsById(id)) throw new NotFoundException();

        ((Indexable) newObject).setId(id);
        repository.save(newObject);
    }

    public void insert(T object) {
        ((Indexable) object).setId(null);
        if (!((Validable) object).isValid()) {
            throw new UnprocessableEntityException("invalid data provided");
        }
        repository.save(object);
    }

    public Long getMaxId() {
        return repository.count();
    }
}

