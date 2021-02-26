package com.ctbroze.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach //Junit 단위테스트가 끝날때마다 수행되는 메서드 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSava_Load() {
        //given
        String title = "title";
        String content = "content";

        postsRepository.save(Posts.builder() //save : 테이블posts에 insert/update 쿼리를 실행, id가 있으면 update 없으면 insert쿼리를 실행한다
                .title(title)
                .content(content)
                .author("ctbroze@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //findAll : 모든 데이터를 조회해오는 메서드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_save(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,12,26,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("ctbroze@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">> createDate="+posts.getCreatedDate()+",modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
