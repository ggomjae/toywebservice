package com.ggomjae.web.toywebservice.service;

import com.ggomjae.web.toywebservice.domain.posts.Posts;
import com.ggomjae.web.toywebservice.domain.replys.Replys;
import com.ggomjae.web.toywebservice.domain.replys.ReplysRepository;
import com.ggomjae.web.toywebservice.web.dto.PostsListResponseDto;
import com.ggomjae.web.toywebservice.web.dto.PostsSaveRequestDto;
import com.ggomjae.web.toywebservice.web.dto.ReplysListResponseDto;
import com.ggomjae.web.toywebservice.web.dto.ReplysSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReplysService {

    private final ReplysRepository replysRepository;

    @Transactional(readOnly = true)
    public List<ReplysListResponseDto> findAllDesc(Long bno){

        return replysRepository.getReplys(bno).stream()
                .map(ReplysListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(ReplysSaveRequestDto replysSaveRequestDto){

        return replysRepository.save(replysSaveRequestDto.toEntity()).getRno();
    }

    @Transactional
    public void delete(Long id){
        Replys replys = replysRepository.findById(id).orElseThrow(()->new
                IllegalArgumentException("not Replys. id=" + id));

        replysRepository.delete(replys);
    }

    @Transactional
    public void deleteAll(Long id){

        replysRepository.deleteReplys(id);
    }
}
