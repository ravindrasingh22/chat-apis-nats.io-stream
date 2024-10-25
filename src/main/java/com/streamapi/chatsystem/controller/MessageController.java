package com.streamapi.chatsystem.controller;

import com.streamapi.chatsystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String fromUserId, @RequestParam String toUserId, @RequestBody String content) {
        messageService.sendMessage(fromUserId, toUserId, content);
        return "Message sent";
    }
}