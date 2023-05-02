package com.playdata.springbootprojectre.web.dto;

import com.playdata.springbootprojectre.service.PostsService;
import com.playdata.springbootprojectre.web.dto.PostsResponseDto;
import com.playdata.springbootprojectre.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //이를 통해 오토와이어드 생략
@RestController //json을 주고 받는 용도
public class PostsApiController {
    private final PostsService postsService; //final

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto); //save 게시판에 대한 것을 저장
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
