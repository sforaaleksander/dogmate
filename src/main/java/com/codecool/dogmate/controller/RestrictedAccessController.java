package com.codecool.dogmate.controller;

import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class RestrictedAccessController<T extends Indexable<ID>, ID> {
    private final GenericService<T, ID> service;

    public RestrictedAccessController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_PREMIUM_USER')")
    public T getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void update(@RequestBody @Valid T newObject, Errors errors, @PathVariable ID id) {
        if (errors.hasErrors()) {
            throw new UnprocessableEntityException();
        }
        service.update(newObject, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void insert(@RequestBody @Valid T entity, Errors errors) {
        if (errors.hasErrors()) {
            throw new UnprocessableEntityException();
        }
        service.insert(entity);
    }

    @GetMapping(params = { "type=allData" })
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_PREMIUM_USER')")
    public Iterable<T> getAll() {
        return service.getAll();
    }
}
