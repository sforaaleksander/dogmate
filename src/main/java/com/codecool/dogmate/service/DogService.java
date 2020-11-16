package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Dog;
import com.codecool.dogmate.repository.DogRepository;
import com.codecool.dogmate.repository.FilterActivePagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DogService extends GenericService<Dog, Long> {

    @Autowired
    DogService(DogRepository repository) {
        super(repository);
    }

    @Override
    public Dog getById(Long id) {
        Optional<Dog> optional = repository.findById(id);
        if (optional.isPresent() && ((Archivable) optional.get()).getActive()) return optional.get();
        throw new NotFoundException();
    }

    @Override
    public Iterable<Dog> getAll(Integer page, Integer size) {
        return ((FilterActivePagingAndSortingRepository<Dog, Long>) repository).findAllByIsActiveTrue(PageRequest.of(page, size)).getContent();
    }
}
