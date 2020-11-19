package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Temper;
import com.codecool.dogmate.repository.TemperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperService extends GenericService<Temper, Long> {

    private final TemperCachingFactory temperCachingFactory;

    @Autowired
    TemperService(TemperCachingFactory temperCachingFactory, TemperRepository repository) {
        super(repository);
        this.temperCachingFactory = temperCachingFactory;
    }

    @Override
    public Iterable<Temper> getAll(Integer page, Integer size, String[] sortBy) {
        return temperCachingFactory.getAllTempers();
    }

    @Override
    public Temper getById(Long id) {
        return temperCachingFactory.getTemper(id);
    }

    @Override
    public void update(Temper newObject, Long aLong) {
        super.update(newObject, aLong);
    }
}
