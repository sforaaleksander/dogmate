package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Breed;
import com.codecool.dogmate.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BreedService extends GenericPagingAndSortingService<Breed, Long> {

    @Autowired
    BreedService(BreedRepository repository) {
        super(repository);
    }

    @Override
    @Cacheable("breeds")
    public Breed getById(Long id) {
        return super.getById(id);
    }
}
