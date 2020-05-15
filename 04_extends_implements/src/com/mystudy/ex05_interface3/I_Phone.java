package com.mystudy.ex05_interface3;
/*
인터페이스 구성요소(Java8 이전)
	- 상수변수 : public static final 변수
	- 추상메소드 : public abstract 메소드
Java8(JDK8)에서 추가된 요소
	- public default 메소드 : 기능 구현 가능(default 메소드)
	- public static 메소드 : 기능 구현 가능(static 메소드)
*/

public interface I_Phone {
	//상수화된 변수 : 인터페이스에 정의된 모든 변수는 public static final 변수
	public static final boolean SUCCESS_CALL = true;
	boolean FAIL_CALL = true; //public static final 생략 가능
	
	//public abstract : 추상메소드(abstract method)
//	public abstract String getType();
//	public String getPhoneNo(); //abstract 생략됨
	
	public abstract void call(); //public abstract 생략됨
	public void receiveCall(); //public abstract 생략됨
	void view(); //public abstract 생략됨
	
	//----------------------------------------
	//default 메소드
	public default void changeNo(String PhoneNo) {
		//이미 구현된 메소드로 필요하면 구현을 하고, 필요없으면 구현 안해도 됨
	}
	
	//static 메소드
	public static void staticMethod() {
		System.out.println("I_Phone 인터페이스의 static 메소드~~~");
	}
}











