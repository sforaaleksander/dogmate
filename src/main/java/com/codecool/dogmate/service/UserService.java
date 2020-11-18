package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.FilterActivePagingAndSortingRepository;
import com.codecool.dogmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends GenericService<User, Long> {
    private PasswordEncoder passwordEncoder;

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
    public Iterable<User> getAll(Integer page, Integer size, String[] sortBy) {
        return ((FilterActivePagingAndSortingRepository<User, Long>) repository).findAllByIsActiveTrue(PageRequest.of(page, size, Sort.by(sortBy))).getContent();
    }

    @Override
    public void insert(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        super.repository.save(user);
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
