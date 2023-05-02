package com.playdata.springbootprojectre.service;

import com.playdata.springbootprojectre.domain.Posts;
import com.playdata.springbootprojectre.domain.PostsRepository;
import com.playdata.springbootprojectre.web.dto.PostsSaveRequestDto;
import com.playdata.springbootprojectre.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service // component를 담고 있기 때문에 자동으로 Bean을 생성해준다.
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto) {
        // 수정할 대상의 레코드가 있는지 확인
        Posts posts = postsRepository.findById(id) //findByID 해당되는 PK값 찾아서 반환
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + id));
        return new PostsResponseDto(posts);
    }
}
