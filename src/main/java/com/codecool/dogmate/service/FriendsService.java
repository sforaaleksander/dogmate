package com.codecool.dogmate.service;

import com.codecool.dogmate.exception.NotFoundException;
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
import java.util.function.Predicate;

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

    public Iterable<Friends> getUserFriendsById(Long id, Predicate<Friends> filter) {
        Optional<User> optionalUser = userRepository.findById(id);

        Iterable<Friends> relatedUsers = Collections.emptyList();
        Iterable<Friends> relatingUsers = Collections.emptyList();

        if (optionalUser.isPresent()) {
            relatedUsers = repository.findAllByRelatedUser(optionalUser.get());
            relatingUsers = repository.findAllByRelatingUser(optionalUser.get());
        }
        Set<Friends> friends = new HashSet<>();
        relatedUsers.forEach(u -> {
            if (filter.test(u)) friends.add(u);
        });
        relatingUsers.forEach(u -> {
            if (filter.test(u)) friends.add(u);
        });
        return friends;
    }

    @Override
    public void update(Friends newObject, FriendsKey friendsKey) {
        FriendsKey friendsKey1 = new FriendsKey(friendsKey.getRelatedUserId(), friendsKey.getRelatingUserId());

        if (!repository.existsById(friendsKey) && !repository.existsById(friendsKey1)) throw new NotFoundException();

        Friends old = getById(friendsKey);
        if (old == null) old = getById(friendsKey1);

        old.setId(friendsKey);
        old.setAccepted(newObject.isAccepted());
        repository.save(newObject);
    }

    @Override
    public void insert(Friends object) {
//        if (!((Validable) object).isValid()) {
//            throw new UnprocessableEntityException("invalid data provided");
//        }
        repository.save(object);
    }

    @Override
    public Friends getById(FriendsKey friendsKey) {
        Optional<Friends> optional = repository.findById(friendsKey);
        return optional.orElse(null);
    }

    @Override
    public void removeById(FriendsKey friendsKey) {
        FriendsKey friendsKey1 = new FriendsKey(friendsKey.getRelatedUserId(), friendsKey.getRelatingUserId());

        if (!repository.existsById(friendsKey) && !repository.existsById(friendsKey1)) throw new NotFoundException();

        Friends friends = getById(friendsKey);
        if (friends == null) friends = getById(friendsKey1);

        repository.delete(friends);
    }
}
