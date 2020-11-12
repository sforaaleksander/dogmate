package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Dog;
import com.codecool.dogmate.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dogs")
public class DogController extends GenericController<Dog> {

    @Autowired
    DogController(DogService dogService) {
        super(dogService);
    }
}
