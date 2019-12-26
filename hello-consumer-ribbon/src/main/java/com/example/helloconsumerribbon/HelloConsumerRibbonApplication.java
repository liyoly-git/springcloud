package com.example.helloconsumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class HelloConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloConsumerRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("hello")
    public ResponseEntity<String> hello(String name){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?name=" + name,String.class);
    }
}
