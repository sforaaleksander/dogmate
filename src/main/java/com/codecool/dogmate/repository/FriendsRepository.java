package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.FriendsKey;
import com.codecool.dogmate.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends PagingAndSortingRepository<Friends, FriendsKey> {

    Iterable<Friends> findAllByRelatedUser(User relatedUser);

    Iterable<Friends> findAllByRelatingUser(User relatedUser);
}
