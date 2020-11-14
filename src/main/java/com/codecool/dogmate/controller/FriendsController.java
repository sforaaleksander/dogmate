package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.FriendsKey;
import com.codecool.dogmate.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/friends")
public class FriendsController {
    private FriendsService friendsService;

    @Autowired
    FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping(value = "/{id}")
    public Friends getById(@PathVariable String id) {
        FriendsKey friendsKey = getFriendsKeyByString(id);
        return friendsService.getById(friendsKey);
    }

    private FriendsKey getFriendsKeyByString(String id) {
        String[] parts = id.split("-");
        FriendsKey friendsKey = new FriendsKey();
        friendsKey.setRelatedUserId(Long.valueOf(parts[0]));
        friendsKey.setRelatingUserId(Long.valueOf(parts[1]));
        return friendsKey;
    }

    @GetMapping
    public Iterable<Friends> getAll() {
        return friendsService.getAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable String id) {
        FriendsKey friendsKey = getFriendsKeyByString(id);
        friendsService.removeById(friendsKey);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody Friends newObject, @PathVariable String id) {
        FriendsKey friendsKey = getFriendsKeyByString(id);
        friendsService.update(newObject, friendsKey);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody Friends entity) {
        friendsService.insert(entity);
    }
}
