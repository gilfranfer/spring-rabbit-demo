package com.gillab.demo.spring.rabbit.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitSender implements MessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Value("${config.mq.products.name}")
    public String PRODUCTS_QUEUE;

    public RabbitSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(PRODUCTS_QUEUE, message);
    }

    @Override
    public String getMessageQueueName() {
        return PRODUCTS_QUEUE;
    }

}
