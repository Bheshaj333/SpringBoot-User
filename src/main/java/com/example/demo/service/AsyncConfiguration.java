package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class AsyncConfiguration implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        // 8 core X 2
        return Executors.newFixedThreadPool(16);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            log.error(
                    "Exception with message : {}, Method: {}, Number of parameters: {}",
                    ex.getMessage(),
                    method,
                    params.length);
        };
    }
}