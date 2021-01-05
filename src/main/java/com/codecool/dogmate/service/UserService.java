package com.codecool.dogmate.service;

import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericPagingAndSortingRemovableService<User, Long> {
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService(UserRepository repository) {
        super(repository);
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
