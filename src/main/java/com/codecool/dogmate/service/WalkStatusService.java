package com.codecool.dogmate.service;

import com.codecool.dogmate.model.WalkStatus;
import com.codecool.dogmate.repository.WalkStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WalkStatusService extends GenericPagingAndSortingService<WalkStatus, Long> {

    @Autowired
    WalkStatusService(WalkStatusRepository repository) {
        super(repository);
    }

    @Override
    @Cacheable("walk_statuses")
    public Iterable<WalkStatus> getAll(Integer page, Integer size, String[] sortBy) {
        return super.getAll(page, size, sortBy);
    }

    @Override
    @Cacheable("walk_statuses")
    public WalkStatus getById(Long aLong) {
        return super.getById(aLong);
    }
}
