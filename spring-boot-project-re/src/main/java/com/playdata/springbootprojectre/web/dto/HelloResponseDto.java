package com.playdata.springbootprojectre.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //lombok의 annotation, final 필드가
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
