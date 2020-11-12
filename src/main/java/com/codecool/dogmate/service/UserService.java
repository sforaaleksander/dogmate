package com.codecool.dogmate.service;

import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User> {

    @Autowired
    UserService(UserRepository repository) {
        super(repository);
    }
}
