package com.gillab.demo.spring.rabbit.config.controller;

import com.gillab.demo.spring.rabbit.config.model.Product;
import com.gillab.demo.spring.rabbit.service.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @Slf4j
@RequestMapping("/spring-rabbit/demo/products")
public class ProductController {

    private final MessageSender messageSender;

    public ProductController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        messageSender.sendMessage(product.toString());
        log.info("Product sent to queue {}: {}", messageSender.getMessageQueueName(), product);
        return ResponseEntity.ok(product);
    }

}
