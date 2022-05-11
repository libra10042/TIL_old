package com.spring.biz.common;

//(실습) @Aspect, @Pointcut, @After 적용
//getPointcut
public class AfterAdvice {
	public void afterLog() {
		System.out.println("[후처리-AfterAdvice.afterLog]"
				+ " 비즈니스 로직 수행후 로그(언제나,무조건)");
	}
}
