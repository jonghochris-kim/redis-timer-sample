package com.chris.example.redistimersample.controller;

import com.chris.example.redistimersample.timer.RegisterTimer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/redis-timer/messages")
@RequiredArgsConstructor
public class RedissonMessageController {

    private final RegisterTimer registerTimer;

    @PostMapping("/register/timers/{message}")
    Mono<?> registerTimer(@PathVariable String message) {
        registerTimer.registerTimer(message);

        return Mono.just(message);
    }
}
