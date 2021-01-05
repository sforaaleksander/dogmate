package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.WalkArea;
import com.codecool.dogmate.repository.WalkAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalkAreaService extends GenericPagingAndSortingRemovableService<WalkArea, Long> {

    @Autowired
    WalkAreaService(WalkAreaRepository repository) {
        super(repository);
    }

    @Override
    public WalkArea getById(Long id) {
        Optional<WalkArea> optional = repository.findById(id);
        if (optional.isPresent() && optional.get().getActive()) return optional.get();
        throw new NotFoundException();
    }
}
