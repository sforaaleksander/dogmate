package com.codecool.dogmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DogMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogMateApplication.class, args);
    }
}
