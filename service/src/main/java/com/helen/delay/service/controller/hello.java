package com.helen.delay.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 樊喆
 */
@RestController
public class hello {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
