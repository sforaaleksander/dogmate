package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.FilterActiveCrudRepository;
import com.codecool.dogmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optional = repository.findById(id);
        if (optional.isPresent() && ((Archivable) optional.get()).getActive()) return optional.get();
        throw new NotFoundException();
    }

    @Override
    public Iterable<User> getAll() {
        return ((FilterActiveCrudRepository<User, Long>) repository).findAllByIsActiveTrue();
    }
}
