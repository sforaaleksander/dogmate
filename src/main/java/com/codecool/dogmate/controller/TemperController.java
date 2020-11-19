package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Temper;
import com.codecool.dogmate.service.TemperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/tempers")
public class TemperController extends RestrictedAccessGenericController<Temper, Long> {
    static Temper tempTemper;
    @Autowired
    TemperController(TemperService temperService) {
        super(temperService);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Temper getById(@PathVariable Long id) {
        Temper byId = super.getById(id);
        System.out.println(tempTemper==byId);
        tempTemper=byId;
        return byId;
    }
}
