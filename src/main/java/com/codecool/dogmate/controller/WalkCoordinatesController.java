package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.WalkCoordinates;
import com.codecool.dogmate.service.WalkCoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/walk-coordinates")
public class WalkCoordinatesController extends CommonAccessGenericController<WalkCoordinates, Long> {

    @Autowired
    WalkCoordinatesController(WalkCoordinatesService walkCoordinatesService) {
        super(walkCoordinatesService);
    }
}