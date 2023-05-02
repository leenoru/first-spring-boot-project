package com.playdata.springbootprojectre.web.dto;


import com.playdata.springbootprojectre.domain.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    public Posts toEntity() {
        return Posts.builder()
              .title(title)
              .content(content)
              .author(author)
              .build();
    }
}
