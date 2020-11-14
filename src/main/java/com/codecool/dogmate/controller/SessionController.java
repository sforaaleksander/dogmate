package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Session;
import com.codecool.dogmate.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController extends GenericController<Session, String> {

    @Autowired
    SessionController(SessionService sessionService) {
        super(sessionService);
    }
}
