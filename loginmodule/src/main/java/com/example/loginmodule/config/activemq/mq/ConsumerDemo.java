package com.example.loginmodule.config.activemq.mq;//package com.example.springtbootkey.redis.config.activemq.mq;
//
//import com.example.springtbootkey.redis.config.activemq.RejectedExecutionHandlerDemo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.*;
//
///**
// * @author zhangxueliang7
// * @version 1.0
// * @date 2024/8/7 19:26
// */
//@Component
//@Slf4j
//public class ConsumerDemo {
//
//    /**
//     * 线程池的自定义的拒绝策略
//     * 就是将拒绝的线程缓存起来
//     */
//    @Autowired
//    private RejectedExecutionHandlerDemo rejectedExecutionHandlerDemo;
//
////    containerFactory = "jmsListenerContainerFactory"
//    @JmsListener(destination = "${queue.test}")
////    @SendTo("${queue.test.response}")
//    public void receive(String textMessage) {
//
//        try {
//            String test = textMessage;
//            log.info("消费的消息队列信息" + test);
//        } catch (Exception e) {
//            log.error("消费消息异常" + e);
//        }
//
//    }
//
//
//    @JmsListener(destination = "${queue.test}")
////    @SendTo("${queue.test.response}")
//    public void receive1(String textMessage) {
//
//        try {
//            String test = textMessage;
//            log.info("消费的消息队列信息q" + test);
//        } catch (Exception e) {
//            log.error("消费消息异常" + e);
//        }
//
//    }
//
//
//
//    @JmsListener(destination = "${queue.test}")
////    @SendTo("${queue.test.response}")
//    public void receive2(String textMessage) {
//
//        try {
//            String test = textMessage;
//            log.info("消费的消息队列信息c" + test);
//        } catch (Exception e) {
//            log.error("消费消息异常" + e);
//        }
//
//    }
//
//    public void get() {
//        //延时执行线程的线程池
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//        //获取服务器的核心数
//        int coreNum = Runtime.getRuntime().availableProcessors();
//
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreNum, coreNum * 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30000), rejectedExecutionHandlerDemo);
//
//        //线程池执行任务，我想要实现的就是给线程池中的每个执行线程命名，之后出现异常可以快速的排查问题   有助于定义问题的范围
//
//
//        //上面是关于线程池的使用  已经自定义线程池的拒绝策略
//
//
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        //关于线程池中使用的线程，可以自己定义   或者更换成自己想要实现的内容   现在先不研究   只使用默认的线程池中的线程
//
//
//    }
//
//
//}
