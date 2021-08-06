package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        /*
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
        */
        return id + " " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        //각각의 컨트롤러의 메소드마다 로그를 찍는부분을 모을수가 있다.
        /*
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
        */
        return user;
    }

    @Timer//직접 만든 어노테이션을 붙힌다.
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        //만약 AOP의 기능이 없었다면 해당부분들이 다 들어가야 된다.
        /*
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // TODO: 2021-08-06  실제 서비스 로직
        // Business적인 로직이 아닌대 같은 코드가 중복되기 때문에 AOP로 제거해 주는것 이다.

        stopWatch.stop();
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
        */
        //db logic 1~2 초 걸린다는 과정
        Thread.sleep(1000*2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
