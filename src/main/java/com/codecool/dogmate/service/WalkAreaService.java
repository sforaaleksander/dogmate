package com.codecool.dogmate.service;

import com.codecool.dogmate.model.WalkArea;
import com.codecool.dogmate.repository.WalkAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalkAreaService extends GenericService<WalkArea> {

    @Autowired
    WalkAreaService(WalkAreaRepository repository) {
        super(repository);
    }
}
