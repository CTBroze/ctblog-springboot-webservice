package com.ctbroze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //테스트코드, 스프링시작전 게시글 50개를 등록하고 시작
    /*
    @Bean
    public CommandLineRunner initPostData(PostsRepository postsRepository) {
        return (args) -> {
            IntStream.rangeClosed(1, 50).forEach(i -> {
                Posts posts = Posts.builder()
                        .tag(new Long(1))
                        .title("title" + i)
                        .content("content" + i)
                        .author("author" + i)
                        .build();

                postsRepository.save(posts);
            });
        };
    }
    */
}