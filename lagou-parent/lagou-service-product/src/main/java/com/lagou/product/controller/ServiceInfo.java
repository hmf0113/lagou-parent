package com.lagou.product.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class ServiceInfo {
    @Value("${server.port}")
    private String port;

    @GetMapping("getPort")
    public String getPort(){

        return port;
    }



}
