package com.example.helloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class HelloServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class, args);
    }

    @RequestMapping("hello")
    public String hello(String name) throws InterruptedException {
        return "hello, " + name;
    }

}
