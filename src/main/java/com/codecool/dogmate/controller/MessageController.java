package com.codecool.dogmate.controller;

import com.codecool.dogmate.model.Message;
import com.codecool.dogmate.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint}/messages")
public class MessageController extends CommonAccessGenericController<Message, Long> {

    @Autowired
    MessageController(MessageService messageService) {
        super(messageService);
    }
}