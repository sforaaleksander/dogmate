package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Coordinates;
import com.codecool.dogmate.repository.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatesService extends GenericService<Coordinates> {

    @Autowired
    CoordinatesService(CoordinatesRepository repository) {
        super(repository);
    }
}
