package com.gillab.demo.spring.rabbit.config.model;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Product {

    private Integer id;
    private String name;
    private Double price;

}
