package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect//AOP로 동작시키는 어노테이션
@Component//Spring에서 관리하기 때문에 component
public class ParameterAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    //com.example.aop.controller 하위에 있는 모든 메소드를 다 AOP로 보겠다.
    //인터넷에 검색하면 많은 수식이 나온다.
    private void cut(){
        //메소드 명은 상관 없다
    }

    //메소드 시작 전(Before)
    @Before("cut()")//메소드 이름을 넣어준다.//PointCut이 실행되는 지점에서 실행
    public void before(JoinPoint joinPoint){
        //메소드명 가지고 오기
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();//매소드의 매개변수배열

        //메소드명 가지고 오기
        for(Object obj : args){
            System.out.println("type : "+obj.getClass().getSimpleName());
            System.out.println("value : "+obj);
        }
    }

    //메소드 리턴 후
    //AfterReturning 같은 경우 Object를 받을수 있다.
    //returning에 받고싶은 객체을 이름을 써준다 ->매개변수와 이름이 같아야된다.
    @AfterReturning(value = "cut()",returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint,Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);
    }
}
