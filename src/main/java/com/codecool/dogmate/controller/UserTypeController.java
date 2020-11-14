package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.UserType;
import com.codecool.dogmate.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-types")
public class UserTypeController extends GenericController<UserType, Long> {

    @Autowired
    UserTypeController(UserTypeService userTypeService) {
        super(userTypeService);
    }
}
