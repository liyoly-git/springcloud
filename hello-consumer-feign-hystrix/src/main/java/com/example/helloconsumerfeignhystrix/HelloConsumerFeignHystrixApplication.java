package com.example.helloconsumerfeignhystrix;

import com.example.helloconsumerfeignhystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients
@RestController
@EnableHystrixDashboard
@SpringBootApplication
public class HelloConsumerFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloConsumerFeignHystrixApplication.class, args);
    }

    @Autowired
    private HelloService helloService;

    @RequestMapping("hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
