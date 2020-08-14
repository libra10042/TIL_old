package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

import com.spring.biz.user.UserVO;

public class AfterReturningAdvice {
//	public void afterReturnLog() {
//		System.out.println("[후처리-AfterReturningAdvice.afterReturnLog]"
//				+ " 비즈니스 로직 수행후 로그(정상실행시)");
//	}
	
	// returnObj : 추가 바인드 변수를 사용시에는 스프링 설정파일에 작성추가
	// 명시적으로 스프링 프레임워크에 매개변수값을 받을 변수명 알림
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		
		//리턴받은 객체를 확인하고 필요한 작업 처리
		if (returnObj instanceof UserVO) {
			UserVO vo = (UserVO) returnObj;
			if ("admin".equalsIgnoreCase(vo.getRole())) {
				System.out.println(vo.getName() + " 로그인(Admin)");
			} else {
				System.out.println(vo.getName() + " 로그인");
			}
		}
		
		System.out.println("[사후처리] " + methodName + "() 메소드"
				+ ", 리턴값 : " + returnObj);
	}	
}









