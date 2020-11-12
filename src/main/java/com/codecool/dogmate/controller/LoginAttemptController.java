package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.LoginAttempt;
import com.codecool.dogmate.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginAttempts")
public class LoginAttemptController extends GenericController<LoginAttempt> {

    @Autowired
    LoginAttemptController(LoginAttemptService loginAttemptService) {
        super(loginAttemptService);
    }
}
