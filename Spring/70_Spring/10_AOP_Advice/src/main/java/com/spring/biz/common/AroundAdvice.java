package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable  {
		//핵심메소드 실행 전
		System.out.println("[Around BEFORE] 비즈니스 로직 실행전 처리");
		
		Object returnObj = pjp.proceed(); //실행할 메소드 동작 시키기
		
		//핵심메소드 실행 후
		System.out.println("[Around AFTER] 비즈니스 로직 실행후 처리");
		
		return returnObj;
	}
}






