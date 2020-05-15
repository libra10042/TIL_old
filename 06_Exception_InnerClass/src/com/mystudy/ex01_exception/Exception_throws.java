package com.mystudy.ex01_exception;

public class Exception_throws {

	public static void main(String[] args) {
		// throws : 예외를 던질 때(위임, 전가) 사용
		// 예외를 발생한 곳에서 처리하지 않고 예외를 던져서 다른 곳에서 처리하도록 함
		// 메소드를 호출한 곳에서 처리하도록 예외를 던짐
		System.out.println("---- main() 시작 ----");
		int num1 = 100;
		int num2 = 0;
		int result = 0;
		
		System.out.println(">> 연산처리 시작");
		result = div(num1, num2);
		System.out.println(">>div() 연산결과 : " + result);
		
		System.out.println("==========================");
		result = -999;
		try {
			result = divThrows(num1, num2);
		} catch(ArithmeticException e) {
			//전달받은 예외를 잡아서 처리
			System.out.println("main() divThrows() 호출 처리시 예외발생~~");
		}
		
		System.out.println(">>divThrows() 처리결과 : " + result);
		
		
		System.out.println("---- main() 끝 ----");
	}
	
	//예외처리방식1 : 메소드 내부에서 예외(Exception)를 직접 처리한 경우
	static int div(int num1, int num2) {
		System.out.println("--->> div() 시작");
		int result = Integer.MIN_VALUE;
		try {
			result = num1 / num2;
		} catch(ArithmeticException e) {
			System.out.println("[div예외발생] " + e.getMessage());
		}
		System.out.println("--->> div() 끝");
		return result;
	}
	
	//예외처리방식2 : 메소드 내에서 발생한 예외(Exception)을 직접 처리하지 않고
	//    호출한 곳에서 예외처리 하도록 예외(들)를 던지기(throws)
	static int divThrows(int num1, int num2) throws ArithmeticException {
		System.out.println("==> divThrows() 시작");
		int result = -1;
		result = num1 / num2;
		
		System.out.println("==> divThrows() 끝");
		return result;
	}

}










