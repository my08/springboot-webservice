package com.springboot.book;

import com.springboot.book.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith : 테스트 진행 시 JUnit에 내장된 실행자 외 다른 실행자를 실행시킨다. (스트링부트테스트 - Junit사이 연결자)
@RunWith(SpringRunner.class)
//@WebMvcTest : web에 집중할 수 있는 어노테이션
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;    //웹 api를 테스트할때 사용

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))          //http get 요청
                .andExpect(status().isOk())             //mvc.perform의 결과 검증(200, 404, 500 등)
                .andExpect(content().string(hello));    //컨트롤러에서 hello를 반환하므로 이 값이 맞나 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
