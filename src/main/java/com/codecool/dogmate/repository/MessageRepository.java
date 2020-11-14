package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Message;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
