package com.codecool.dogmate.auth;

import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.UserRepository;
import com.codecool.dogmate.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final UserRepository userRepository;

    @Autowired
    public FakeApplicationUserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.flatMap(this::convertToApplicationUser);
    }

    private Optional<ApplicationUser> convertToApplicationUser(User user) {
        return Optional.of(new ApplicationUser(
                user.getEmail(),
                user.getPassword(),
                ApplicationUserRole.valueOf(user.getUserType().getName().toUpperCase()).getGrantedAuthorities(),
                true,
                true,
                true,
                user.getActive()
        ));
    }
}
