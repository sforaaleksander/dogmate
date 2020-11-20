package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Temper;
import com.codecool.dogmate.repository.TemperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TemperCachingFactory {

    private static final Map<Long, Temper> cachedTempers = new ConcurrentHashMap<>();
    private final TemperRepository repository;
    private Iterable<Temper> tempers;

    @Autowired
    public TemperCachingFactory(TemperRepository repository) {
        this.repository = repository;
        populateMap();
    }

    public Temper getTemper(Long id) {
        Temper temper = cachedTempers.get(id);
        if (temper == null) {

            Optional<Temper> optional = repository.findById(id);
            if (optional.isPresent()) temper = optional.get();
            else throw new NotFoundException();

            cachedTempers.put(id, temper);
        }
        return temper;
    }

    public Iterable<Temper> getAllTempers() {
        return tempers;
    }

    private void populateMap() {
        tempers = repository.findAll(PageRequest.of(0, 10, Sort.by("id"))).getContent();

        for (Temper temper : tempers) {
            cachedTempers.put(temper.getId(), temper);
        }
    }
}
