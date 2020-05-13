package com.ggomjae.web.toywebservice.web.dto;

import com.ggomjae.web.toywebservice.domain.posts.Posts;
import com.ggomjae.web.toywebservice.domain.replys.Replys;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReplysSaveRequestDto {

    private String content;
    private String author;
    private Long bno;

    @Builder
    public ReplysSaveRequestDto(String content, String author,Posts posts){
        this.content = content;
        this.author = author;
        this.bno = bno;
    }

    public Replys toEntity(){
        return Replys.builder()
                .content(content)
                .author(author)
                .bno(bno)
                .build();
    }
}
