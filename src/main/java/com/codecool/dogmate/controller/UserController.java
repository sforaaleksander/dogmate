package com.codecool.dogmate.controller;

import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("${api.endpoint}/users")
public class UserController extends CommonAccessRemovableGenericController<User, Long> {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody @Valid User entity, Errors errors) {
        if (errors.hasErrors()) {
            throw new UnprocessableEntityException();
        }
        userService.insert(entity);
    }
}
