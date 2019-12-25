package net.ctblog.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //Junit 단위테스트가 끝날때마다 수행되는 메서드 지정
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
}
