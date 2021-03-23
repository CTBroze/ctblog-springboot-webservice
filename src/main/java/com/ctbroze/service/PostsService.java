package com.ctbroze.service;

import com.ctbroze.domain.posts.Posts;
import com.ctbroze.domain.posts.PostsRepository;
import com.ctbroze.web.dto.PostsListResponseDto;
import com.ctbroze.web.dto.PostsResponseDto;
import com.ctbroze.web.dto.PostsSaveRequestDto;
import com.ctbroze.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findByOrderByIdDesc(){
        return postsRepository.findByOrderByIdDesc().stream()
                        .map(PostsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))와 동일
                        .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findTop10ByOrderByIdDesc(){
        return postsRepository.findTop10ByOrderByIdDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(posts); //JPARepository에서 delete를 지원하므로 활용한다.
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

}
