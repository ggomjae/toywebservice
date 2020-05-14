package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.service.PostsService;
import com.ggomjae.web.toywebservice.service.ReplysService;
import com.ggomjae.web.toywebservice.web.dto.*;

import lombok.RequiredArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class BoardController {

    private final PostsService postsService;
    private final ReplysService replysService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

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

    //@DeleteMapping("/api/board/posts/{id}")
    @RequestMapping(value ="/api/board/posts/{id}", method = RequestMethod.DELETE)
    public Long delete(@PathVariable Long id){

        postsService.delete(id);
        replysService.deleteAll(id);

        return id;
    }

    @GetMapping("/api/board/all")
    public List<PostsListResponseDto> findAllPosts(){
        logger.info("ggomjae");
        List<PostsListResponseDto> postAll = postsService.findAllDesc();

        return postAll;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////test/////////////////////////////////////////////////////////////////
    @GetMapping("/api/board/dto")
    public HelloResponseDto boardDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}