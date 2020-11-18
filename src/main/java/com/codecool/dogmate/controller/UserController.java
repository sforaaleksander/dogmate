package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.User;
import com.codecool.dogmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/users")
public class UserController extends CommonAccessRemovableGenericController<User, Long> {

    @Autowired
    UserController(UserService userService) {
        super(userService);
    }
}
