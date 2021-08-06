package com.example.springioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder")
//Spring에서 관리하도록 설정하는 어노테이션
//@Component(생성할 빈이름) 으로 Bean이름을 지정할수도 있고, 지정 안하게 될 경우
//class을 맨 앞글자가 소문자로 바뀐 이름으로 빈이 생성된다.
public class Base64Encoder implements IEncoder{
    //빈으로 등록
    //빈으로 등록되 것들을 SpringBootApplication 붙은되서 확인할수  있다.
    //스프링이 시작이 될떄 해당 어노테이션이 붙은 클래스를 찾아서 직접객체를 생성해서 싱글톤 형태로 객체를 관리한다.
    //꺼내쓰는 방법
    //SpringApplicationContext 를 통해 객체를 가지고 올수 있다.
    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
