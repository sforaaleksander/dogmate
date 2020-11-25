package com.codecool.dogmate.service;

import com.codecool.dogmate.model.WalkCoordinates;
import com.codecool.dogmate.repository.WalkCoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalkCoordinatesService extends GenericService<WalkCoordinates, Long> {
    //todo check if coordinates can be cascade removed after removing walk,
    // do we need to extend GenericRemovableService instead

    @Autowired
    WalkCoordinatesService(WalkCoordinatesRepository repository) {
        super(repository);
    }
}


