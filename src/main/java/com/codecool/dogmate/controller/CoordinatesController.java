package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coordinates")
public class CoordinatesController extends GenericController<Coordinates> {

    @Autowired
    CoordinatesController(CoordinatesService coordinatesService) {
        super(coordinatesService);
    }
}
