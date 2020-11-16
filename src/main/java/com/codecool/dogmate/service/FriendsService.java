package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.FriendsKey;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.FriendsRepository;
import com.codecool.dogmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FriendsService extends GenericService<Friends, FriendsKey> {

    private final FriendsRepository repository;
    private final UserRepository userRepository;

    @Autowired
    FriendsService(FriendsRepository repository, UserRepository userRepository) {
        super(repository);
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Iterable<Friends> getUserFriendsById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        Iterable<Friends> relatedUsers = Collections.emptyList();
        Iterable<Friends> relatingUsers = Collections.emptyList();

        if (optionalUser.isPresent()) {
            relatedUsers = repository.findAllByRelatedUser(optionalUser.get());
            relatingUsers = repository.findAllByRelatingUser(optionalUser.get());
        }
        Set<Friends> friends = new HashSet<>();
        relatedUsers.forEach(u -> {
            if (u.isAccepted()) friends.add(u);
        });
        relatingUsers.forEach(u -> {
            if (u.isAccepted()) friends.add(u);
        });
        return friends;
    }

    @Override
    public Friends getById(FriendsKey friendsKey) {
        Optional<Friends> optional = repository.findById(friendsKey);
        return optional.orElse(null);
    }
}
