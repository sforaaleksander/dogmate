package com.codecool.dogmate.controller;

import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Override
    public User specificUpdate(User original, User updated) {
        if (updated.getName() != null) {
            original.setName(updated.getName());
        }
        if (updated.getEmail() != null) {
            original.setEmail(updated.getEmail());
        }
        if (updated.getActive() != null) {
            original.setActive(updated.getActive());
        }
        if (updated.getPassword() != null) {
            original.setPassword(updated.getPassword());
        }
        if (updated.getAbout() != null) {
            original.setAbout(updated.getAbout());
        }
        if (updated.getAvatar() != null) {
            original.setAvatar(updated.getAvatar());
        }
        if (updated.getDogs() != null) {
            original.setDogs(updated.getDogs());
        }
        return original;
    }
}
