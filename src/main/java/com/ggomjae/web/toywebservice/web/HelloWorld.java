package com.ggomjae.web.toywebservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String init(){
        return "init";
    }

    @GetMapping("/api/hello")
    public String hello(){
        return "hello";
    }
}