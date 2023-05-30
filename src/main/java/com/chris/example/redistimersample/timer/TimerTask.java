package com.chris.example.redistimersample.timer;

import java.time.LocalDateTime;

public class TimerTask implements Runnable {

    private String message;

    public TimerTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("TimerTask#run >>>> " + LocalDateTime.now());
        System.out.println("TimerTask#run.message >>>>" + this.message);
    }
}
