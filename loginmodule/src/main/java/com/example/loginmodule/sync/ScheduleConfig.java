package com.example.loginmodule.sync;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/12 14:15
 * <p>
 * 两种方式为springboot的定时任务配置多线程
 * 1.通过ScheduleConfig  配置类重写SchedulingConfigurer接口的 configureTasks方法   并配置线程池，
 * 2.通过ScheduleConfig   注入TaskScheduler  bean  配置线程池
 * <p>
 * 总结：
 * 以上两种实现其中之一即可
 */
@Configuration
public class ScheduleConfig {

    //这个与configureTasks  是一套
//    public class ScheduleConfig implements SchedulingConfigurer {


//    /**
//     * 重写SchedulingConfigurer  的 configureTasks  方法
//     * @param taskRegistrar
//     */
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setScheduler(Executors.newFixedThreadPool(10));
//    }


    //    /**
//     * 配置TaskScheduler 配置线程池
//     *
//     * @return
//     */
    @Bean("taskSchedulerDemo")
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskExecutor = new ThreadPoolTaskScheduler();
        threadPoolTaskExecutor.setPoolSize(10);
        return threadPoolTaskExecutor;
    }
}
