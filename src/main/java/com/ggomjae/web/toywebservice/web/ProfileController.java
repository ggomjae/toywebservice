package com.ggomjae.web.toywebservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    @GetMapping("/api/profile")
    public Map<String,String> hello(){
        Map<String,String> person = new HashMap<String, String>();
        person.put("name","KimDaMi");
        person.put("age","25");

        return person;
    }
}
