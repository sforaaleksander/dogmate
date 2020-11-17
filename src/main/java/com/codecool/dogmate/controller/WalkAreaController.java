package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.WalkArea;
import com.codecool.dogmate.service.WalkAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/walk-areas")
public class WalkAreaController extends GenericController<WalkArea, Long> {

    @Autowired
    WalkAreaController(WalkAreaService walkAreaService) {
        super(walkAreaService);
    }
}
