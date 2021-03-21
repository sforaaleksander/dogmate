package com.codecool.dogmate.dto;

import com.codecool.dogmate.model.Dog;
import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.User;
import com.codecool.dogmate.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FriendsListService {

    private FriendsService friendsService;

    @Autowired
    public void setFriendsService(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    public List<FriendsListDTO> getAllFriends(Long id) {
        Iterable<Friends> friendsList = friendsService.getUserFriendsById(id, Friends::isAccepted);
        List<User> friendsOfUser = getOnlyFriends(friendsList, id);
        return friendsOfUser.stream().map(this::convertToFriendsListDTO).collect(Collectors.toList());
    }

    private List<User> getOnlyFriends(Iterable<Friends> friendsList, Long id) {
        List<User> friends = new ArrayList<>();
        for (Friends f : friendsList) {
            if (!f.getRelatedUser().getId().equals(id)) {
                friends.add(f.getRelatedUser());
            }
            if (!f.getRelatingUser().getId().equals(id)) {
                friends.add(f.getRelatingUser());
            }
        }
        return friends;
    }

    private FriendsListDTO convertToFriendsListDTO(User user) {
        FriendsListDTO friendsListDTO = new FriendsListDTO();
        friendsListDTO.setId(user.getId());
        friendsListDTO.setName(user.getName());
        friendsListDTO.setImg(user.getAvatar());
        friendsListDTO.setDogs(convertDogsToFriendsListDTO(user.getDogs()));
        return friendsListDTO;
    }

    private DogsToFriendsListDTO convertToDogWithNameOnly(Dog dog) {
        DogsToFriendsListDTO newDog = new DogsToFriendsListDTO();
        newDog.setName(dog.getName());
        return newDog;
    }

    private Set<DogsToFriendsListDTO> convertDogsToFriendsListDTO(Set<Dog> dogs) {
        return dogs.stream().map(this::convertToDogWithNameOnly).collect(Collectors.toSet());
    }
}
