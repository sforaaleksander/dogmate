package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Temper;
import com.codecool.dogmate.service.TemperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/tempers")
public class TemperController extends RestrictedAccessController<Temper, Long> {

    @Autowired
    TemperController(TemperService temperService) {
        super(temperService);
    }
}
