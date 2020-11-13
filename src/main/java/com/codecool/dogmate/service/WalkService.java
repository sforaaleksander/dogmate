package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Walk;
import com.codecool.dogmate.repository.FilterActiveCrudRepository;
import com.codecool.dogmate.repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalkService extends GenericService<Walk, Long> {

    @Autowired
    WalkService(WalkRepository repository) {
        super(repository);
    }

    @Override
    public Walk getById(Long id) {
        Optional<Walk> optional = repository.findById(id);
        if (optional.isPresent() && ((Archivable) optional.get()).getActive()) return optional.get();
        throw new NotFoundException();
    }

    @Override
    public Iterable<Walk> getAll() {
        return ((FilterActiveCrudRepository<Walk, Long>) repository).findAllByIsActiveTrue();
    }
}
