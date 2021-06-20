package com.ctbroze.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private Long tag;
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(Long tag, String title, String content){
        this.tag = tag;
        this.title = title;
        this.content = content;
    }

}
