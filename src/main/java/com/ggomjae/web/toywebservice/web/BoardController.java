package com.ggomjae.web.toywebservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @GetMapping("/api/board")
    public String hello(){
        return "Gomjae";
    }
}