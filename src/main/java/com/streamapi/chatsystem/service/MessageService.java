package com.streamapi.chatsystem.service;


import io.nats.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private Connection natsConnection;

    public void sendMessage(String fromUserId, String toUserId, String content) {
        String subject = "chat." + fromUserId + "." + toUserId;
        try {
            natsConnection.publish(subject, content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
