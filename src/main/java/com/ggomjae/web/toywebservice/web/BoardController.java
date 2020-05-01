package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BoardController {

    @GetMapping("/api/board")
    public Map<String,String> hello(){
        Map<String,String> person = new HashMap<String, String>();
        person.put("name","KimDaMi");
        person.put("age","25");

        return person;
    }

    @GetMapping("/api/board/dto")
    public HelloResponseDto boardDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}