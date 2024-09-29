package com.example.loginmodule.config.activemq;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.jms.*;


/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/8 20:31
 */
@Configuration
@Slf4j
public class ActiveMqConfig {

    @Value("${spring.activemq.broker-url}")
    private String url;

    @Value("${spring.activemq.user}")
    private String username;

    @Value("${spring.activemq.password}")
    private String password;

    public Queue queue(String queueName) {
        return new ActiveMQQueue(queueName);
    }

    public Topic getTopic() {
        return new ActiveMQTopic();
    }


    /**
     * 创建生产者和消费者
     *
     * @param queueName
     * @return
     */
    public Pair<MessageProducer, MessageConsumer> createProducerAndConsumer(String queueName) {
        try {
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(username, password, url);

            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = queue(queueName);


            //指定一个目的地，也就是一个队列的位置

            //这个是m默认的过期的消息队列  可以连接对接处理过期的消息

//            Queue queue1 = session.createQueue("ActiveMQ.DLQ");

            MapMessage mapMessage = session.createMapMessage();

            ObjectMessage objectMessage = session.createObjectMessage();


            //创建了生产者队列
            MessageProducer producer = session.createProducer(queue);
            //创建了消费者队列
            MessageConsumer consumer = session.createConsumer(queue);
            return new Pair<>(producer, consumer);
        } catch (Exception e) {
            log.error("创建生产者和消费者异常" + e);
        }
        return null;
    }
}
