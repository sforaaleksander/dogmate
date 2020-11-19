package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Temper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TemperCachingFactory {

    private static final Map<Long, Temper> cachedTempers = new ConcurrentHashMap<>();
    private final GenericService<Temper, Long> service;
    private Iterable<Temper> tempers;

    @Autowired
    public TemperCachingFactory(GenericService<Temper, Long> service) {
        this.service = service;
        populateMap();
    }

    public Temper getTemper(Long id) {
        Temper temper = cachedTempers.get(id);
        if (temper == null) {
            temper = service.getById(id);
            cachedTempers.put(id, temper);
        }
        return temper;
    }

    public Iterable<Temper> getAllTempers() {
        return tempers;
    }

    private void populateMap() {
        tempers = service.getAll(0, 10, new String[]{"id"});
        for (Temper temper : tempers) {
            cachedTempers.put(temper.getId(), temper);
        }
    }
}
