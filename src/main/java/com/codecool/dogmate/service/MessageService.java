package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Message;
import com.codecool.dogmate.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends GenericService<Message, Long> {

    @Autowired
    MessageService(MessageRepository repository) {
        super(repository);
    }
}
