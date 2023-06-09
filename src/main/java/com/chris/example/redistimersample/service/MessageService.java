package com.chris.example.redistimersample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {

    public void sendMessage(String message) {
        log.info("MessageService#sendMessage {}", message);
    }
}
