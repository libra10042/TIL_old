package com.spring.biz.common;

public class AfterThrowingAdvice {
	public void exceptionLog() {
		System.out.println("[후처리-AfterThrowingAdvice.exceptionLog]"
				+ " 비즈니스 로직 수행중 예외발생시 로그");
	}
}
