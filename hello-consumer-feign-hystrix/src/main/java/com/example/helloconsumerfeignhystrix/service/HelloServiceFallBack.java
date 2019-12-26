package com.example.helloconsumerfeignhystrix.service;

import org.springframework.stereotype.Component;

/**
 * @author ly
 * @date 2019/12/26
 */
@Component
public class HelloServiceFallBack implements HelloService{

    @Override
    public String hello(String name){
        return "hello, hystrix     == fail name : " + name;
    }

}
