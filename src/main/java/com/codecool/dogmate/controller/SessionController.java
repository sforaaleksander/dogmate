package com.codecool.dogmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class SessionController extends GenericController<Session> {

    @Autowired
    SessionController(SessionService sessionService) {
        super(sessionService);
    }
}
