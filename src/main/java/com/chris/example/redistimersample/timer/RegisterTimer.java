package com.chris.example.redistimersample.timer;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RScheduledExecutorService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterTimer {

    private final RScheduledExecutorService rScheduledExecutorService;

    public void registerTimer(String message) {
        // Executor 가 종료된 상태이면 재등록될 수 있도록 종료시킨다.
        if (rScheduledExecutorService.isShutdown()) {
            rScheduledExecutorService.delete();
        }

        log.info("RegisterTimer#registerTimer >>>> " + LocalDateTime.now());

        // delay 시간 뒤에 Redis Scheduler 가 태스크를 작동시킨다.
        rScheduledExecutorService.schedule(
            new TimerTask(message),
            3L,
            TimeUnit.SECONDS
        );
    }
}
