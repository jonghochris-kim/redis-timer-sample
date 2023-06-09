package com.chris.example.redistimersample.timer;

import com.chris.example.redistimersample.service.MessageService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TimerTask implements Runnable {

    @Autowired
    private MessageService messageService;

    private String message;

    public TimerTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("TimerTask#run >>>> " + LocalDateTime.now());
        System.out.println("TimerTask#run.message >>>>" + this.message);

        messageService.sendMessage(this.message);
    }
}
