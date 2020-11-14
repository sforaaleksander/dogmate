package com.codecool.dogmate.service;

import com.codecool.dogmate.model.WalkStatus;
import com.codecool.dogmate.repository.WalkStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalkStatusService extends GenericService<WalkStatus, Long> {

    @Autowired
    WalkStatusService(WalkStatusRepository repository) {
        super(repository);
    }
}
