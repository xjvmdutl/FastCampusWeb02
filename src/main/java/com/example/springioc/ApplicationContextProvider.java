package com.example.springioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //외부로 부터 주입을 받는다.
        //스프링이 주입해준다.
        context = applicationContext;
    }

    public static ApplicationContext getContext(){
        //외부로 부터 주입받을것을 가지고 온다.
        return context;
    }
}
