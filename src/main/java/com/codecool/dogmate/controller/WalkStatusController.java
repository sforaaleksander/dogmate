package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.WalkStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/walkStatuss")
public class WalkStatusController extends GenericController<WalkStatus> {

    @Autowired
    WalkStatusController(WalkStatusService walkStatusService) {
        super(walkStatusService);
    }
}