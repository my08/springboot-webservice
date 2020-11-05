package com.springboot.book.web;

import com.springboot.book.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController : json을 반환하는 컨트롤러 생성
//@ResponseBody를 각 메소드에 선언했던것을 한번에 사용할 수 있게 해줌.
@RestController
public class HelloController {

    //@GetMapping : get요청을 받을 수 있는 api생성
    //==@RequestMapping(method=ReqeustMethod.GET)
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
