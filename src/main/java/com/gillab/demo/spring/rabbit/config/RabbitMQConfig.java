package com.gillab.demo.spring.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConfig {

    @Value("${config.mq.products.name}")
    public String PRODUCTS_QUEUE;

    @Bean
    public Queue queue() {
        return new Queue(PRODUCTS_QUEUE, false);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

}
