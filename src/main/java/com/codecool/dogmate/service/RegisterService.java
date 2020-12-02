package com.codecool.dogmate.service;

import com.codecool.dogmate.model.User;
import com.codecool.dogmate.model.UserType;
import com.codecool.dogmate.repository.UserRepository;
import com.codecool.dogmate.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private UserTypeRepository userTypeRepository;

    @Autowired
    RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserTypeRepository userTypeRepository ) {
        this.userTypeRepository = userTypeRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void insert(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserType defaultUserType = userTypeRepository.findById(1L).orElseThrow();
        user.setUserType(defaultUserType);
        userRepository.save(user);
    }
}
