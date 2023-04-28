package com.playdata.springbootprojectre.web.dto;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloResponseDtoTest {
    @Test
    public void lombokTest() {
        //given
        String name = "더더덕";
        int amount  = 10000;

        //when
        // @RequiredArgsConstructor 가 정말 필요한 필드에 대해서 생성자를 생성하는지 확인
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}