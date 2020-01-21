package net.ctblog.service;

import lombok.RequiredArgsConstructor;
import net.ctblog.domain.posts.Posts;
import net.ctblog.web.dto.PostsListResponseDto;
import net.ctblog.web.dto.PostsResponseDto;
import net.ctblog.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ctblog.domain.posts.PostsRepository;
import net.ctblog.web.dto.PostsSaveRequestDto;

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
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                        .map(PostsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))와 동일
                        .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당게시글이 없습니다. id="+id));

        postsRepository.delete(posts); //JPARepository에서 delete를 지원하므로 활용한다.
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

}
