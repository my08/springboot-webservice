package com.springboot.book.dto;

import com.springboot.book.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name); //isEqualTo : assertj의 동등비교메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
