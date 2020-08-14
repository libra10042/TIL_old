package com.spring.biz.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //객체(인스턴스) 생성
@Aspect // 포인트컷 + 어드바이스 연결
public class BeforeAdvice {

	//어드바이스 메소드
	//어드바이스의 동작시점 설정 + 포인트컷 지정
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); //실행될 메소드명
		Object[] args = jp.getArgs();
		System.out.println("args : " + Arrays.toString(args));
		
		String argsMsg = (args.length == 0) ? "없음" : args[0].toString();
		System.out.println("[사전처리] " + methodName + "() 메소드"
				+ ", args정보 : " + argsMsg + " - 비즈니스 로직 수행전 로그");
	}	
}











