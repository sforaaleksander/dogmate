package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Friends;
import com.codecool.dogmate.model.FriendsKey;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends PagingAndSortingRepository<Friends, FriendsKey> {
}
