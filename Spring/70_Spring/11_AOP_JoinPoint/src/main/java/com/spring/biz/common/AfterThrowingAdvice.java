package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
//	public void exceptionLog() {
//		System.out.println("[후처리-AfterThrowingAdvice.exceptionLog]"
//				+ " 비즈니스 로직 수행중 예외발생시 로그");
//	}
	
	// JoinPoint 이외 바인드변수 exceptObj 사용
	public void exceptionLog(JoinPoint jp, Exception exceptObj ) {
		String methodName = jp.getSignature().getName();
		
		if (exceptObj instanceof IllegalArgumentException) {
			System.out.println(">>> 부적합한 값이 전달되었습니다.");
		} else if (exceptObj instanceof NumberFormatException) {
			System.out.println(">>> 숫자형식이 아닙니다");
		} else if (exceptObj instanceof Exception) {
			System.out.println(">>> 예외가 발생했습니다");
		}
		
		System.out.println("[예외발생] " + methodName + "() 메소드"
				+ " - 실행중 예외 발생, 메시지 : " + exceptObj.getMessage());
	}	
}








