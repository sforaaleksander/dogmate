package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Dog;
import com.codecool.dogmate.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService extends GenericService<Dog, Long> {

    @Autowired
    DogService(DogRepository repository) {
        super(repository);
    }
}
