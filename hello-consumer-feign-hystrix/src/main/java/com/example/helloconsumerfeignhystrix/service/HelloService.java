package com.example.helloconsumerfeignhystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ly
 * @date 2019/12/26
 */
@FeignClient(value = "hello-service",fallback = HelloServiceFallBack.class)
public interface HelloService {

    @RequestMapping("hello")
    String hello(@RequestParam(value = "name") String name);
}
