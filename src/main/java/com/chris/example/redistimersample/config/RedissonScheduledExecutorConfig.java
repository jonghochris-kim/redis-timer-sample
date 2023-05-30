package com.chris.example.redistimersample.config;

import java.util.concurrent.TimeUnit;
import org.redisson.api.ExecutorOptions;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;
import org.redisson.api.WorkerOptions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonScheduledExecutorConfig {

    public static final String EXECUTOR_SERVICE_NAME = "rScheduledExecutor";

    @Bean
    public RScheduledExecutorService rScheduledExecutorService(
        final RedissonClient redissonClient,
        final BeanFactory beanFactory
    ) {
        final WorkerOptions workerOptions = WorkerOptions.defaults().workers(2).beanFactory(beanFactory);
        final ExecutorOptions executorOptions = ExecutorOptions.defaults().taskRetryInterval(3, TimeUnit.SECONDS);
        final RScheduledExecutorService rScheduledExecutorService = redissonClient.getExecutorService(EXECUTOR_SERVICE_NAME, executorOptions);
        rScheduledExecutorService.registerWorkers(workerOptions);

        return rScheduledExecutorService;
    }
}
