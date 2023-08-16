package com.lagou.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author HP
 * 表示eureka
 */
@SpringBootApplication
@EnableEurekaServer //表示为服务端eureka
public class EurekaApplication9201 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication9201.class,args);
    }
}
