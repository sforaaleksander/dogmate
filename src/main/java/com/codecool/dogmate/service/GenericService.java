package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Indexable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class GenericService<T extends Indexable<ID>, ID> {
    protected final CrudRepository<T, ID> repository;

    protected GenericService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public Iterable<T> getAll() {
        return repository.findAll();
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
