package com.ggomjae.web.toywebservice.web.dto;

import com.ggomjae.web.toywebservice.domain.replys.Replys;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class ReplysListResponseDto {

    private Long rno;
    private Long bno;
    private String author;
    private String content;
    private LocalDateTime modifiedDate;

    public ReplysListResponseDto (Replys entity){
        this.rno = entity.getRno();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}