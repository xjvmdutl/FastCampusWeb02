package com.example.di;

public class Encoder {
    //DI
    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder){
        
        //this.iEncoder = new Base64Encoder();//초기에는 Base64
        //this.iEncoder = new UrlEncoder();//추가 요구사항으로 바꿧다.
        //해당 부분을 코드 수정이 들어갔다 //테스트 할때마다 본질 클래스를 건들여야 한다.
        //DI 적용 -> 외부에서 객체를 주입해준다.
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
