package com.codecool.dogmate.controller;

import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.service.GenericPagingAndSortingService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class CommonAccessGenericController<T extends Indexable<ID>, ID> {
    protected final GenericPagingAndSortingService<T, ID> service;

    CommonAccessGenericController(GenericPagingAndSortingService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_PREMIUM_USER')")
    public Iterable<T> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String... sortBy
            ) {
        return service.getAllPagedAndSorted(page, size, sortBy);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_PREMIUM_USER')")
    public T getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_PREMIUM_USER')")
    public void update(@RequestBody @Valid T newObject, Errors errors, @PathVariable ID id) {
        if (errors.hasErrors()) {
            throw new UnprocessableEntityException();
        }
        service.update(newObject, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_PREMIUM_USER')")
    public void insert(@RequestBody @Valid T entity, Errors errors) {
        if (errors.hasErrors()) {
            throw new UnprocessableEntityException();
        }
        service.insert(entity);
    }
}
