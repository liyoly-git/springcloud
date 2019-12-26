package com.example.helloconsumerribbonhystrix;

import com.example.helloconsumerribbonhystrix.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@EnableDiscoveryClient
@EnableHystrix
@RestController
@EnableHystrixDashboard
@SpringBootApplication
public class HelloConsumerRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloConsumerRibbonHystrixApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Resource
    private HelloService helloService;

    @RequestMapping("hello")
    public String hello(String name){
        return helloService.hello(name);
    }
}
