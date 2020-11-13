package com.codecool.dogmate.service;

import com.codecool.dogmate.model.LoginAttempt;
import com.codecool.dogmate.model.Session;
import com.codecool.dogmate.repository.LoginAttemptRepository;
import com.codecool.dogmate.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LoginAttemptService extends GenericService<LoginAttempt, Long> {

    private SessionRepository sessionRepository;

    @Autowired
    LoginAttemptService(LoginAttemptRepository repository) {
        super(repository);
    }

    @Override
    public void insert(LoginAttempt object) {
        super.insert(object);
        if (object.isSuccessful()) {
            final long duration = 1000L * 60 * 60 * 24 * 365;

            Timestamp endTime = new Timestamp(object.getTime().getTime());
            endTime.setTime(object.getTime().getTime() + duration);

            sessionRepository.save(new Session("someId", object.getUser(), object.getTime(), endTime, object));
        }
    }

    @Autowired
    public void setSessionRepository(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
}
