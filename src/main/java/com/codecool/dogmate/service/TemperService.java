package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Temper;
import com.codecool.dogmate.repository.TemperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperService extends GenericService<Temper> {

    @Autowired
    TemperService(TemperRepository repository) {
        super(repository);
    }
}
