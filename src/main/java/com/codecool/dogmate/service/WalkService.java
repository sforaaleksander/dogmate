package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Walk;
import com.codecool.dogmate.repository.FilterActivePagingAndSortingRepository;
import com.codecool.dogmate.repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Iterable<Walk> getAll(Integer page, Integer size, String[] sortBy) {
        return ((FilterActivePagingAndSortingRepository<Walk, Long>) repository).findAllByIsActiveTrue(PageRequest.of(page, size, Sort.by(sortBy))).getContent();
    }
}
