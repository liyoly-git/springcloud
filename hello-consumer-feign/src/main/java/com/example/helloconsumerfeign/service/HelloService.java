package com.example.helloconsumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ly
 * @date 2019/12/25
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("hello")
    String hello (@RequestParam(value = "name") String name);
}
