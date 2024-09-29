package com.example.loginmodule.config.activemq.threadpool;

import com.example.loginmodule.config.activemq.RejectedExecutionHandlerDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/9 19:41
 */
@Component
public class ThreadPoolExecutorConfig {

    /**
     * 线程池的自定义的拒绝策略
     * 就是将拒绝的线程缓存起来
     */
    @Autowired
    private RejectedExecutionHandlerDemo rejectedExecutionHandlerDemo;

    public ThreadPoolExecutor threadPoolExecutor() {
        int coreNum = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(coreNum, coreNum * 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30000), rejectedExecutionHandlerDemo);
    }
}
