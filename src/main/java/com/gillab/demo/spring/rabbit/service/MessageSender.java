package com.gillab.demo.spring.rabbit.service;

public interface MessageSender {
    void sendMessage(String message);
    String getMessageQueueName();
}
