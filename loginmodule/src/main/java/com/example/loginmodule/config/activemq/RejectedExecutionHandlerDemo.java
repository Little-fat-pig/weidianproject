package com.example.loginmodule.config.activemq;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/9 13:52
 */
@Component
public class RejectedExecutionHandlerDemo implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            ArrayBlockingQueue fieldValuesArrayBlockingQueue = new ArrayBlockingQueue<>(20000);
            fieldValuesArrayBlockingQueue.add(r);
        }
    }
}
