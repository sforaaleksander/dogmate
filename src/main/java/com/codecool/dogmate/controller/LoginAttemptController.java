package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.LoginAttempt;
import com.codecool.dogmate.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/login-attempts")
public class LoginAttemptController extends CommonAccessGenericController<LoginAttempt, Long> {

    @Autowired
    LoginAttemptController(LoginAttemptService loginAttemptService) {
        super(loginAttemptService);
    }
}
