package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Indexable;
import com.codecool.dogmate.service.GenericRemovableService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class CommonAccessRemovableGenericController<T extends Indexable<ID> & Archivable, ID> extends CommonAccessGenericController<T, ID> {
    private final GenericRemovableService<T, ID> service;

    CommonAccessRemovableGenericController(GenericRemovableService<T, ID> service) {
        super(service);
        this.service = service;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_PREMIUM_USER')")
    public void deleteById(@PathVariable ID id) {
        service.removeById(id);
    }
}
