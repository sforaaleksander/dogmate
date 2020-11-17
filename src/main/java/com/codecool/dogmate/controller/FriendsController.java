package com.codecool.dogmate.controller;

import com.codecool.dogmate.exception.NotFoundException;
import com.codecool.dogmate.exception.UnprocessableEntityException;
import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.FriendsKey;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.repository.UserRepository;
import com.codecool.dogmate.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final FriendsService friendsService;
    private final UserRepository userRepository;

    @Autowired
    FriendsController(FriendsService friendsService, UserRepository userRepository) {
        this.friendsService = friendsService;
        this.userRepository = userRepository;
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
        return friendsService.getUserFriendsById(id, Friends::isAccepted);
    }

    @GetMapping(value = "/pending/{id}")
    public Iterable<Friends> getPendingFriendsForUserWithId(@PathVariable Long id) {
        return friendsService.getUserFriendsById(id, f -> !f.isAccepted());
    }

    @GetMapping(value = "/{id}/{id2}")
    public Friends getFriendRelationById(@PathVariable Long id, @PathVariable Long id2) {
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
    @DeleteMapping(value = "/{id}/{id2}")
    public void deleteById(@PathVariable Long id, @PathVariable Long id2) {
        FriendsKey friendsKey = new FriendsKey(id, id2);
        friendsService.removeById(friendsKey);
    }

    @PutMapping(value = "/{id}/{id2}")
    public void update(@RequestBody Friends newObject, @PathVariable Long id, @PathVariable Long id2) {
        FriendsKey friendsKey = new FriendsKey(id, id2);
        friendsService.update(newObject, friendsKey);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{id}")
    public void insert(@RequestBody Friends entity, @PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (entity.getRelatedUser() == null && entity.getRelatingUser() == null
                || optionalUser.isEmpty()) {
            throw new UnprocessableEntityException("invalid data provided");
        }

        if (entity.getRelatedUser() == null) {
            entity.setRelatedUser(optionalUser.get());
            entity.setId(new FriendsKey(id, optionalUser.get().getId()));
        }
        if (entity.getRelatingUser() == null) {
            entity.setRelatingUser(optionalUser.get());
            entity.setId(new FriendsKey(optionalUser.get().getId(), id));
        }
        friendsService.insert(entity);
    }
}
