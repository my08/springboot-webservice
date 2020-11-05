package com.springboot.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication : 스트링부트의 자동설정, 스프링 bean읽기와 생성 모두 자동으로 설정
//@SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에, 항상 프로젝트의 최상단에 위치해야함
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장WAS실행-> 톰캣 불필요, 스트링부트로 만들어진 jar파일 실행하면 됨.
        //언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문
        SpringApplication.run(Application.class, args);
    }
}
