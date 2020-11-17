package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Coordinates;
import com.codecool.dogmate.service.CoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/coordinates")
public class CoordinatesController extends GenericController<Coordinates, Long> {

    @Autowired
    CoordinatesController(CoordinatesService coordinatesService) {
        super(coordinatesService);
    }
}
