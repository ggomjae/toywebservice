package com.ggomjae.web.toywebservice.web;

import com.ggomjae.web.toywebservice.domain.posts.Posts;
import com.ggomjae.web.toywebservice.domain.posts.PostsRepository;
import com.ggomjae.web.toywebservice.service.PostsService;
import com.ggomjae.web.toywebservice.service.ReplysService;
import com.ggomjae.web.toywebservice.web.dto.ReplysListResponseDto;
import com.ggomjae.web.toywebservice.web.dto.ReplysSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplysService replysService;

    @PostMapping("/api/reply/save")
    public Long posts(@RequestBody ReplysSaveRequestDto replysSaveRequestDto){

        return replysService.save(replysSaveRequestDto);
    }

    @GetMapping("/api/reply/all/{bno}")
    public List<ReplysListResponseDto> findAllReplys(@PathVariable("bno") Long bno){

        List<ReplysListResponseDto> replyAll = replysService.findAllDesc(bno);

        return replyAll;
    }
}
