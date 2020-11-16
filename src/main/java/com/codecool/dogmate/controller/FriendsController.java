package com.codecool.dogmate.controller;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.FriendsKey;
import com.codecool.dogmate.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final FriendsService friendsService;

    @Autowired
    FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping
    public Iterable<Friends> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String... sortBy
    ) {
        return friendsService.getAll(page, size, sortBy);
    }

    @GetMapping(value = "/{id}")
    public Iterable<Friends> getFriendsForUserWithId(@PathVariable Long id) {
        return friendsService.getUserFriendsById(id);
    }

    @GetMapping(value = "/{id}/{id2}")
    public Friends getById(@PathVariable Long id, @PathVariable Long id2) {
        FriendsKey friendsKey = new FriendsKey(id, id2);
        FriendsKey friendsKey2 = new FriendsKey(id2, id);
        Friends friends = friendsService.getById(friendsKey);
        Friends friends2 = friendsService.getById(friendsKey2);
        if (friends == null && friends2 == null) {
            throw new NotFoundException();
        }
        return friends != null ? friends : friends2;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable FriendsKey id) {
        friendsService.removeById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody Friends newObject, @PathVariable FriendsKey id) {
        friendsService.update(newObject, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody Friends entity) {
        friendsService.insert(entity);
    }
}
