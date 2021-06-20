package com.ctbroze.web.dto;

import com.ctbroze.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class PostsListResponseDto {
    private Long id;
    private Long tag;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.tag = entity.getTag();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
