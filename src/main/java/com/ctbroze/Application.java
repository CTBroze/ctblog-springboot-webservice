package com.ctbroze;

import com.ctbroze.domain.posts.Posts;
import com.ctbroze.domain.posts.PostsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

//War
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //Post Test Data
    @Bean
    public CommandLineRunner initPostData(PostsRepository postsRepository) {
        return (args) -> {
            IntStream.rangeClosed(1, 50).forEach(i -> {
                Posts posts = Posts.builder()
                        .title("title" + i)
                        .content("content" + i)
                        .author("author" + i)
                        .build();

                postsRepository.save(posts);
            });
        };
    }
}