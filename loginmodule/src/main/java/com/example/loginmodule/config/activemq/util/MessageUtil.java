package com.example.loginmodule.config.activemq.util;

import org.apache.activemq.command.*;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.*;
import java.io.Serializable;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/8/10 14:30
 */@Component
public class MessageUtil implements Session {
    @Override
    public BytesMessage createBytesMessage() throws JMSException {
        return new ActiveMQBytesMessage();
    }

    @Override
    public MapMessage createMapMessage() throws JMSException {
        return new ActiveMQMapMessage();
    }

    @Override
    public Message createMessage() throws JMSException {
        return new ActiveMQMessage();
    }

    @Override
    public ObjectMessage createObjectMessage() throws JMSException {
        return new ActiveMQObjectMessage();
    }

    @Override
    public ObjectMessage createObjectMessage(Serializable serializable) throws JMSException {
        return new ActiveMQObjectMessage();
    }

    @Override
    public StreamMessage createStreamMessage() throws JMSException {
        return new ActiveMQStreamMessage();
    }

    @Override
    public TextMessage createTextMessage() throws JMSException {
        return new ActiveMQTextMessage();
    }

    @Override
    public TextMessage createTextMessage(String s) throws JMSException {
        return null;
    }

    @Override
    public boolean getTransacted() throws JMSException {
        return false;
    }

    @Override
    public int getAcknowledgeMode() throws JMSException {
        return 0;
    }

    @Override
    public void commit() throws JMSException {

    }

    @Override
    public void rollback() throws JMSException {

    }

    @Override
    public void close() throws JMSException {

    }

    @Override
    public void recover() throws JMSException {

    }

    @Override
    public MessageListener getMessageListener() throws JMSException {
        return null;
    }

    @Override
    public void setMessageListener(MessageListener messageListener) throws JMSException {

    }

    @Override
    public void run() {

    }

    @Override
    public MessageProducer createProducer(Destination destination) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createConsumer(Destination destination) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createConsumer(Destination destination, String s) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createConsumer(Destination destination, String s, boolean b) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createSharedConsumer(Topic topic, String s) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createSharedConsumer(Topic topic, String s, String s1) throws JMSException {
        return null;
    }

    @Override
    public Queue createQueue(String s) throws JMSException {
        return null;
    }

    @Override
    public Topic createTopic(String s) throws JMSException {
        return null;
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic topic, String s) throws JMSException {
        return null;
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic topic, String s, String s1, boolean b) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createDurableConsumer(Topic topic, String s) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createDurableConsumer(Topic topic, String s, String s1, boolean b) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createSharedDurableConsumer(Topic topic, String s) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createSharedDurableConsumer(Topic topic, String s, String s1) throws JMSException {
        return null;
    }

    @Override
    public QueueBrowser createBrowser(Queue queue) throws JMSException {
        return null;
    }

    @Override
    public QueueBrowser createBrowser(Queue queue, String s) throws JMSException {
        return null;
    }

    @Override
    public TemporaryQueue createTemporaryQueue() throws JMSException {
        return null;
    }

    @Override
    public TemporaryTopic createTemporaryTopic() throws JMSException {
        return null;
    }

    @Override
    public void unsubscribe(String s) throws JMSException {

    }
}
