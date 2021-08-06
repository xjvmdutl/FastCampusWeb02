package com.example.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})//메소드에 사용
@Retention(RetentionPolicy.RUNTIME)//Run타임에 돈다
public @interface Timer {
}
