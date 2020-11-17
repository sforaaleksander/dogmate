package com.codecool.dogmate.config;

import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.UserRepository;
import com.codecool.dogmate.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TestUsersConfig implements CommandLineRunner {
    private UserTypeRepository userTypeRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public TestUsersConfig(UserTypeRepository userTypeRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userTypeRepository = userTypeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        User admin = new User("admin", "admin@admin.com", passwordEncoder.encode("admin"),
                "this is an admin acc",null, this.userTypeRepository.findById(2L).get());
        admin.setId(99999L);
        User user = new User("user", "user@user.com", passwordEncoder.encode("user"),
                "this is a user acc",null, this.userTypeRepository.findById(1L).get());
        user.setId(99998L);
        List<User> users = Arrays.asList(admin,user);
        userRepository.saveAll(users);
    }
}
