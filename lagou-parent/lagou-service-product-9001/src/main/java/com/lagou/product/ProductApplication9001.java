package com.lagou.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lagou.product.mapper")
public class ProductApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication9001.class,args);
    }
}
