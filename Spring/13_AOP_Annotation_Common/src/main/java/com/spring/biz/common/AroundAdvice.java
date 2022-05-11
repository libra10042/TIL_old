package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//(실습) @Aspect, @Pointcut, @Around 적용
//allPointcut
@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable  {
		String methodName = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("[Around BEFORE] 비즈니스 로직 실행전 처리");
		Object returnObj = pjp.proceed(); //실행할 메소드 동작 시키기
		System.out.println("[Around AFTER] 비즈니스 로직 실행후 처리");
		
		stopWatch.stop();
		
		System.out.println("[around] " + methodName + "() 메소드"
				+", 실행시간 : " + stopWatch.getTotalTimeMillis() + "초(ms)");
		
		return returnObj;
	}	
}






