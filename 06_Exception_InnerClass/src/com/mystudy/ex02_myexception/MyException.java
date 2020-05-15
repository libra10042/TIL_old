package com.mystudy.ex02_myexception;

//예외만들기 : Exception 클래스를 상속받아 만들기
public class MyException extends Exception {
	//생성자
	public MyException() {
		//수퍼(부모) 클래스의 생성자 호출(예외 메시지 전달)
		super(":::내가 만든 Exception");
	}

}
