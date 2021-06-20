package com.ctbroze.web.dto;

import com.ctbroze.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private Long tag;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(Long tag, String title, String content, String author){
        this.tag = tag;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .tag(tag)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
