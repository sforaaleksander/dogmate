package com.codecool.dogmate.populator;

import com.codecool.dogmate.model.Breed;
import com.codecool.dogmate.model.Dog;
import com.codecool.dogmate.model.DogTempers;
import com.codecool.dogmate.model.Temper;
import com.codecool.dogmate.repository.BreedRepository;
import com.codecool.dogmate.repository.DogRepository;
import com.codecool.dogmate.repository.TemperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TemperPopulator implements CommandLineRunner {
    private final TemperRepository temperRepository;
    private final DogRepository dogRepository;
    private final BreedRepository breedRepository;

    @Override
    public void run(String... args) {
        for (DogTempers dogTempers : DogTempers.values()){
            temperRepository.save(new Temper(dogTempers.toString()));
        }
        breedRepository.save(new Breed("dupa"));
        dogRepository.save(new Dog("dupa", true, Date.valueOf("2000-11-11"),
                breedRepository.findById(1L).get(), DogTempers.DUPA,true));
    }

    @Autowired
    public TemperPopulator(TemperRepository temperRepository, DogRepository dogRepository, BreedRepository breedRepository) {
        this.temperRepository = temperRepository;
        this.dogRepository = dogRepository;
        this.breedRepository = breedRepository;
    }
}
