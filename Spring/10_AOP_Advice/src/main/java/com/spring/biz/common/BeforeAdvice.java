package com.spring.biz.common;

public class BeforeAdvice {
	public void beforeLog() {
		System.out.println("[사전처리-BeforeAdvice.beforeLog]"
				+ " 비즈니스 로직 수행전 로그");
	}
}
