package com.codecool.dogmate.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/friends")
public class FriendsListController {
    private FriendsListService friendsListService;

    @Autowired
    public void setFriendsListService(FriendsListService friendsListService) {
        this.friendsListService = friendsListService;
    }

    @GetMapping(value = "/{id}")
    public List<FriendsListDTO> getAllFriendsList(@PathVariable Long id) {
        return friendsListService.getAllFriends(id);
    }
}
