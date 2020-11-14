package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.FriendsKey;
import com.codecool.dogmate.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friends")
public class FriendsController extends GenericController<Friends, FriendsKey> {

    @Autowired
    FriendsController(FriendsService friendsService) {
        super(friendsService);
    }
}
