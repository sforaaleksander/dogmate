package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Walk;
import com.codecool.dogmate.repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalkService extends GenericService<Walk> {

    @Autowired
    WalkService(WalkRepository repository) {
        super(repository);
    }
}
