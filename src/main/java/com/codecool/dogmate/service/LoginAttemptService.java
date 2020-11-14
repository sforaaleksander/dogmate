package com.codecool.dogmate.service;

import com.codecool.dogmate.model.LoginAttempt;
import com.codecool.dogmate.repository.LoginAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAttemptService extends GenericService<LoginAttempt, Long> {

    @Autowired
    LoginAttemptService(LoginAttemptRepository repository) {
        super(repository);
    }
}
