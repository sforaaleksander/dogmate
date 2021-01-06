package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Dog;
import com.codecool.dogmate.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/dogs")
public class DogController extends CommonAccessRemovableGenericController<Dog, Long> {

    @Autowired
    DogController(DogService dogService) {
        super(dogService);
    }

    @Override
    public Dog specificUpdate(Dog original, Dog updated) {
        if (updated.getName() != null) {
            original.setName(updated.getName());
        }
        if (updated.getActive() != null) {
            original.setActive(updated.getActive());
        }
        if (updated.isDefaultDog() != null) {
            original.setDefaultDog(updated.getActive());
        }
        if (updated.getBreed() != null) {
            original.setBreed(updated.getBreed());
        }
        if (updated.getTemper() != null) {
            original.setTemper(updated.getTemper());
        }
        if (updated.isMale() != null) {
            original.setMale(updated.isMale());
        }
        if (updated.getDateOfBirth() != null) {
            original.setDateOfBirth(updated.getDateOfBirth());
        }
        if (updated.isNeutered() != null) {
            original.setNeutered(updated.isNeutered());
        }
        return original;
    }
}
