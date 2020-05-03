package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.service.PostsService;
import com.ggomjae.web.toywebservice.web.dto.HelloResponseDto;
import com.ggomjae.web.toywebservice.web.dto.PostsResponseDto;
import com.ggomjae.web.toywebservice.web.dto.PostsSaveRequestDto;

import com.ggomjae.web.toywebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final PostsService postsService;

    @GetMapping("/api/board")
    public Map<String,String> hello(){
        Map<String,String> person = new HashMap<String, String>();
        person.put("name","KimDaMi");
        person.put("age","25");

        return person;
    }

    @PostMapping("/api/board/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/board/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto ){
        return postsService.update(id,requestDto);
    }

    @GetMapping("/api/board/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @GetMapping("/api/board/dto")
    public HelloResponseDto boardDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}