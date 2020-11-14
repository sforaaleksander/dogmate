package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.model.Validable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class GenericService<T extends Indexable<ID>, ID> {
    protected final CrudRepository<T, ID> repository;

    public GenericService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public Iterable<T> getAll() {
        return repository.findAll();
    }

    private String getEntityName() {
        return this.getClass().getSimpleName().replace("Service", "");
    }

    public T getById(ID id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) return optional.get();
        throw new NotFoundException();
    }

    public void removeById(ID id) {
        T t = getById(id);

        ((Archivable) t).setActive(false);
        repository.save(t);
    }

    public void update(T newObject, ID id) {
        if (!repository.existsById(id)) throw new NotFoundException();

        newObject.setId(id);
        repository.save(newObject);
    }

    public void insert(T object) {
        object.setId(null);
        if (!((Validable) object).isValid()) {
            throw new UnprocessableEntityException("invalid data provided");
        }
        repository.save(object);
    }
}

