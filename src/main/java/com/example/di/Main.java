package com.example.di;

public class Main {

    public static void main(String[] args) {
        //프로그램 내에서 인코딩
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        //요구사항 : base64로 인코딩
        /*
        Base64Encoder encoder = new Base64Encoder();
        String result = encoder.encode(url);
        System.out.println(result);
        //문제업이 동작
        //추가 요구사항 = Url 인코딩
        //계속 추가된다.(추상화로 해결 가능)
        //encode 역활이 같다 -> 인터페이스 생성
        UrlEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);
        System.out.println(urlResult);
        */
        Encoder encoder = new Encoder(new UrlEncoder());
        //Encoder클래스를 바꾸지 않아도 Base64로 동작
        //테스트시 Encoder를 건들지 않고 main만 건들면 된다.
        //새로 만들경우에도 IEncoder를 구현받고  메소드만 구현하면 Encoder를 건들지 않고 생성 가능하다.
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
