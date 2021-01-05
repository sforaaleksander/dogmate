package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.service.GenericPagingAndSortingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


public abstract class RestrictedAccessPagingAndSortingGenericController<T extends Indexable<ID>, ID> extends RestrictedAccessController<T, ID> {
    private final GenericPagingAndSortingService<T, ID> service;

    RestrictedAccessPagingAndSortingGenericController(GenericPagingAndSortingService<T, ID> service) {
        super(service);
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_PREMIUM_USER')")
    public Iterable<T> getAllPagedAndSorted(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String... sortBy
            ) {
        return service.getAllPagedAndSorted(page, size, sortBy);
    }
}
