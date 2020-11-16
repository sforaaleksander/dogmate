package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<T extends Indexable<ID>, ID> {
    private final GenericService<T, ID> service;

    GenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<T> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return service.getAll(page, size);
    }

    @GetMapping(value = "/{id}")
    public T getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable ID id) {
        service.removeById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody T newObject, @PathVariable ID id) {
        service.update(newObject, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody T entity) {
        service.insert(entity);
    }
}
