package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Breed;
import com.codecool.dogmate.repository.BreedRepository;
import com.codecool.dogmate.repository.FilterActiveCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreedService extends GenericService<Breed, Long> {

    @Autowired
    BreedService(BreedRepository repository) {
        super(repository);
    }

}
