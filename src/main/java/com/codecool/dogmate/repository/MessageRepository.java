package com.codecool.dogmate.repository;

import com.codecool.dogmate.model.Message;

public interface MessageRepository extends FilterActiveCrudRepository<Message> {

    Iterable<Message> findAllByIsActiveTrue();
}
