package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	
	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("--- 컨테이너 구동 후 ---");
		
		//2. 스프링 컨테이너 사용
		UserService userService = (UserService) container.getBean("userService");
		
		//2-1. 입력
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		
		//사용자 정보 조회
		UserVO user = userService.getUser(vo);
		System.out.println(">> user : " + user);
		
		//3. 스프링 컨테이너 종료
		container.close();
	}
}
