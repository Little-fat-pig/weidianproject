package com.example.loginmodule.config.activemq.mq;


import com.example.loginmodule.config.activemq.threadpool.ThreadPoolExecutorConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/10 14:43
 */

@Component
@Slf4j
public class ConsumerMessageListener implements MessageListener {


    @Autowired
    private ThreadPoolExecutorConfig threadPoolExecutorConfig;

    /**
     * mq的消费端，重写listner  消费消息
     *
     * @param message
     */

    @Override
    public void onMessage(Message message) {

        try {
            ObjectMessage message1 = (ObjectMessage) message;
            String object = (String) message1.getObject();

            ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorConfig.threadPoolExecutor();
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(object);
                }
            });

            log.info("消息消费的内容" + object);

        } catch (Exception e) {

            log.error("mq的消息过程异常" + e);
        }

    }
}
