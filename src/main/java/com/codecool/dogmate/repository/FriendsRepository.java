package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Friends;

public interface FriendsRepository extends FilterActiveCrudRepository<Friends> {

    Iterable<Friends> findAllByIsActiveTrue();
}
