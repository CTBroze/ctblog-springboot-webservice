package net.ctblog.web;

import lombok.RequiredArgsConstructor;
import net.ctblog.web.dto.PostsResponseDto;
import net.ctblog.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

import net.ctblog.service.PostsService;
import net.ctblog.web.dto.PostsSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long Save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
