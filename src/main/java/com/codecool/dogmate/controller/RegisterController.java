package com.codecool.dogmate.controller;

import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void insert(@RequestBody @Valid User entity, Errors errors) {
        if (errors.hasErrors()) {
            throw new UnprocessableEntityException();
        }
        registerService.insert(entity);
    }

}
