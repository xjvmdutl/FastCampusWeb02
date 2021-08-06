package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component//@Bean같은 경우 Class에 붙힐수 없다.
public class TimerAop {
    //특정 메소드의 특정 시간을 찍을것이다.

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}

    //annotation하위에 Timer어노테이션이 설정된 메소드에만 포인트 컷을 설정 한다.
    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){}

    @Around("cut() && enableTimer()")//두가지 조건 같이쓴다
    //전 후에 실행된다
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        Object result = joinPoint.proceed();//메소드가 생행이되는것이다.
       //특정값을 리턴시 result에 값이 들어간다.
        
        stopWatch.stop();
        //초단위 출력
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
        //Timer 어노테이션만 붙히면 시간을 바로 찍을수 있다.
    }
}
