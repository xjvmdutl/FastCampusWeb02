package com.example.springioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Encoder {

    private IEncoder iEncoder;

    /*
        public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder){
        // 해당 Encoder도 빈으로 등록시 에러가 뜬다
        // (why? SPring에서 선택된 빈이 한개만 있을경우 바로 맞춰 주지만 현재는 두개라서 어떤것을 매칭해야되는지 스프링에서 모른다)
        //Qualifier(빈이름) 을 통해서 명시적으로 지정하면 된다.
            this.iEncoder = iEncoder;
        }
    */

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    //스프링에서 주입받는 장소는 변수,생성자,set메소드이다.
    public void setiEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }


    public String encode(String message){
        return iEncoder.encode(message);
    }
}
