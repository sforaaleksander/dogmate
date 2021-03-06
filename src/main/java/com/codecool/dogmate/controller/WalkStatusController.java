package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.WalkStatus;
import com.codecool.dogmate.service.WalkStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/walk-status")
public class WalkStatusController extends RestrictedAccessPagingAndSortingGenericController<WalkStatus, Long> {

    @Autowired
    WalkStatusController(WalkStatusService walkStatusService) {
        super(walkStatusService);
    }
}
