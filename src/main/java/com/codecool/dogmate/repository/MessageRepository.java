package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Message;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
}
