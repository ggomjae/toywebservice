package com.ggomjae.web.toywebservice.service;

import com.ggomjae.web.toywebservice.domain.posts.Posts;
import com.ggomjae.web.toywebservice.domain.posts.PostsRepository;
import com.ggomjae.web.toywebservice.web.dto.PostsResponseDto;
import com.ggomjae.web.toywebservice.web.dto.PostsSaveRequestDto;
import com.ggomjae.web.toywebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id , PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("unUser. id = "+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){

        Posts entity = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("unUser. id =" +id));

        return new PostsResponseDto(entity);
    }

}
