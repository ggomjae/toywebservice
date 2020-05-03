package com.ggomjae.web.toywebservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void clean(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSave(){
        String title = "title";
        String content = "content";

        postsRepository.save(Posts.builder()
            .title(title)
            .content(content)
            .author("ggomjae@naver.com")
            .build());

        List<Posts> list = postsRepository.findAll();

        Posts posts = list.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
