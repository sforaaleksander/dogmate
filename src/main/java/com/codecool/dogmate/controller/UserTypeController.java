package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userTypes")
public class UserTypeController extends GenericController<UserType> {

    @Autowired
    UserTypeController(UserTypeService userTypeService) {
        super(userTypeService);
    }
}
