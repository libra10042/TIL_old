package com.mystudy.ex03_interface;

//인터페이스 : 추상체
public interface I_Phone {
	/* 인터페이스 선언된 추상메소드(abstract method)
	 * public abstract 메소드임
	 */
	public abstract void call();
	public void receiveCall(); //abstract 생략가능
	void view(); //public abstract 생략가능
	
	void sendMsg(); //public abstract 메소드
	void receiveMsg(); //public abstract 메소드
}







