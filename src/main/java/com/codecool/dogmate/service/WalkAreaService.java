package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.WalkArea;
import com.codecool.dogmate.repository.FilterActiveCrudRepository;
import com.codecool.dogmate.repository.WalkAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalkAreaService extends GenericService<WalkArea, Long> {

    @Autowired
    WalkAreaService(WalkAreaRepository repository) {
        super(repository);
    }

    @Override
    public WalkArea getById(Long id) {
        Optional<WalkArea> optional = repository.findById(id);
        if (optional.isPresent() && ((Archivable) optional.get()).getActive()) return optional.get();
        throw new NotFoundException();
    }

    @Override
    public Iterable<WalkArea> getAll() {
        return ((FilterActiveCrudRepository<WalkArea, Long>) repository).findAllByIsActiveTrue();
    }
}
