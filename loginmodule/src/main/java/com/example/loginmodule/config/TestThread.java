package com.example.loginmodule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/6 11:32
 */
@Configuration
public class TestThread {

    @Bean("testThread1")
    public ThreadPoolExecutor threadPoolExecutor(){

//        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();

        return new ThreadPoolExecutor(16,32,300000, TimeUnit.SECONDS,new ArrayBlockingQueue<>(20000));
    }
}
