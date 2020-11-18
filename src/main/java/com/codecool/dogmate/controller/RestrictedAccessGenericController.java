package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

public abstract class RestrictedAccessGenericController<T extends Indexable<ID>, ID> {
    private final GenericService<T, ID> service;

    RestrictedAccessGenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Iterable<T> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String... sortBy
            ) {
        return service.getAll(page, size, sortBy);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public T getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteById(@PathVariable ID id) {
        service.removeById(id);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void update(@RequestBody T newObject, @PathVariable ID id) {
        service.update(newObject, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void insert(@RequestBody T entity) {
        service.insert(entity);
    }
}
