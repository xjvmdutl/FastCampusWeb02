package com.example.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@SpringBootApplication
public class SpringIocApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringIocApplication.class, args);

		ApplicationContext context = ApplicationContextProvider.getContext();
		//빈은 클래스명과 빈이름으로 가지고 올수 있다.
		//Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);//빈으로 등록된 클레스 가지고 오기
		//UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

		Encoder encoder = context.getBean("urlEncode",Encoder.class);
		//기본적으로 설정한 것이 64이기 때문에 Base64를 불러올 필요 없다.
		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
		String result = encoder.encode(url);
		System.out.println(result);
		//스프링에서 모든 객체를 주입받아서 사용한다.
		//스프링에서 모든 생명주기가 관리된다

	}

}
@Configuration
//한 클래스에서 여러개의 빈을 등록할 것이다(내부적으로 @component를 가지고 있다)
class AppConfig{
	@Bean("base64Encode")
	public Encoder encoder(Base64Encoder base64Encoder){
		//개발자가 만들더라도 코드에서 new 를 하는것이 아니라 빈을 미리 생성해 주입한다.
		return new Encoder(base64Encoder);
	}
	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder){
		return new Encoder(urlEncoder);
	}
}