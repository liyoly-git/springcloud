package com.example.helloconsumerribbonhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ly
 * @date 2019/12/25
 */
@Service
public class HelloService {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    public String hello (String name){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello?name=" + name,String.class).getBody();
    }

    public String fallback (String name){
        return "hello, hystrix       === fail name:" + name;
    }
}
