package com.ggomjae.web.toywebservice.domain.replys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ggomjae.web.toywebservice.domain.BaseTimeEntity;
import com.ggomjae.web.toywebservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Replys extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private Long bno;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    private String author;

    @Builder
    public Replys(String content, String author, Long bno){
        this.content = content;
        this.author = author;
        this.bno = bno;
    }
}
