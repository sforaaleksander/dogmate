package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Breed;
import com.codecool.dogmate.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/breeds")
public class BreedController extends GenericController<Breed, Long> {

    @Autowired
    BreedController(BreedService breedService) {
        super(breedService);
    }
}
