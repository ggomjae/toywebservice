package com.ggomjae.web.toywebservice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Builder;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
