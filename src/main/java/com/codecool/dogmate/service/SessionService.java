package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Session;
import com.codecool.dogmate.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService extends GenericPagingAndSortingService<Session, String> {

    @Autowired
    SessionService(SessionRepository repository) {
        super(repository);
    }
}
