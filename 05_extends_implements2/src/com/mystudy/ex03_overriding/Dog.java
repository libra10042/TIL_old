package com.mystudy.ex03_overriding;

public class Dog extends Animal {
	
	@Override
	void sound() {
		System.out.println(">> 멍~~ 멍~~");
	}
	
	//메소드 오버라이드로 동작하지 않음(파라미터 형태가 다름)
	void sound(String str) {
		System.out.println(str + ">> 멍~~ 멍~~");
	}
}
