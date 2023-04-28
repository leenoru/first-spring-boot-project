package com.playdata.springbootprojectre.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest

class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository; //테스트인 관계로 이러한 필드 형태로 만들어서 진행

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndLoad(){
        // given
        String title = "테스트 게시글";
        String content = "테스트 게시글 내용";
        String author = "플레이 데이터";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        // when
        Posts posts = postsRepository.findAll().get(0);

        // then
        assertEquals(posts.getTitle(),title);
        assertEquals(posts.getContent(),content);
        assertEquals(posts.getAuthor(),author);
    }
}