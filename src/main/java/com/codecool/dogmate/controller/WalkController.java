package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Walk;
import com.codecool.dogmate.service.WalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/walks")
public class WalkController extends CommonAccessRemovableGenericController<Walk, Long> {

    @Autowired
    WalkController(WalkService walkService) {
        super(walkService);
    }

    @Override
    public void specificUpdate(Walk original, Walk updated) {
        //TODO implement
    }
}
