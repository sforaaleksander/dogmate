package com.codecool.dogmate.auth;

import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.UserRepository;
import com.codecool.dogmate.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private ApplicationUser convertToApplicationUser(User user) {
        return new ApplicationUser(
                user.getId(),
                user.getAvatar(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                ApplicationUserRole.valueOf(user.getUserType().getName().toUpperCase()).getGrantedAuthorities(),
                true,
                true,
                true,
                user.getActive()
        );
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) return convertToApplicationUser(optionalUser.get());
        throw new UsernameNotFoundException(String.format("Username %s not found", email));
    }
}
