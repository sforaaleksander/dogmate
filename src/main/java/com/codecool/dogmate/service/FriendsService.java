package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService extends GenericService<Friends> {

    @Autowired
    FriendsService(FriendsRepository repository) {
        super(repository);
    }
}
