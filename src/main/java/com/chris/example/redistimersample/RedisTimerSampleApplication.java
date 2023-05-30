package com.chris.example.redistimersample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedisTimerSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisTimerSampleApplication.class, args);
    }

}
