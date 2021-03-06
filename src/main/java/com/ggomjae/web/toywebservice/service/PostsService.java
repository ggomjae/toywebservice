package com.ggomjae.web.toywebservice.service;

import com.ggomjae.web.toywebservice.domain.posts.Posts;
import com.ggomjae.web.toywebservice.domain.posts.PostsRepository;
import com.ggomjae.web.toywebservice.web.dto.PostsListResponseDto;
import com.ggomjae.web.toywebservice.web.dto.PostsResponseDto;
import com.ggomjae.web.toywebservice.web.dto.PostsSaveRequestDto;
import com.ggomjae.web.toywebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){

        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

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

    @Transactional
    public PostsResponseDto findById (Long id){

        Posts entity = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("unUser. id =" +id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new
                IllegalArgumentException("not Post. id=" + id));

        postsRepository.delete(posts);
    }
}
