package com.ctbroze.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //카테고리와 상관없이 전체 게시글 내림차순 조회
    List<Posts> findByOrderByIdDesc();

    //전체 게시글 중 최신 10개의 게시글 내림차순 조회
    List<Posts> findTop10ByOrderByIdDesc();

    //요청받은 태그의 게시글 목록 내림차순 정렬하연 전체 조회
    @Query("SELECT p FROM Posts p WHERE p.tag = :tag ORDER BY p.id DESC")
    Page<Posts> findByOrderByIdDescWhereTag(@Param("tag") Long tag, Pageable pageable);
}
