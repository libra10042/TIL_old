package com.mystudy.ex05_interface;

//인터페이스(기본적으로 모두가 추상체)
//단, default, static 메소드는 구현체
public interface I_Animal {
	public abstract void eat(); //추상메소드
	abstract void sleep(); //추상메소드(public 생략됨)
	void sound(); //추상메소드(public abstract 생략됨)
}
