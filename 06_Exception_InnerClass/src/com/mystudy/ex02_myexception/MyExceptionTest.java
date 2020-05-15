package com.mystudy.ex02_myexception;

public class MyExceptionTest {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		
		try {
			firstMethod();
		} catch (MyException e) {
			System.out.println(">> main() catch 문 실행");
			System.out.println(">> 오류메시지 : " + e.getMessage());
		}
		
		System.out.println("--- main() 끝 ---");
	}

	static void firstMethod() throws MyException {
		System.out.println("-- firstMethod() 시작 ---");
		secondMethod();
		System.out.println("-- firstMethod() 끝 ---");
	}

	static void secondMethod() throws MyException {
		System.out.println("---- secondMethod() 시작 ---");
		throw new MyException(); //예외발생
		
	}
}









