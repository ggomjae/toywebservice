package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @GetMapping("/api/board")
    public String hello(){
        return "Gomjae";
    }

    @GetMapping("/api/board/dto")
    public HelloResponseDto boardDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}