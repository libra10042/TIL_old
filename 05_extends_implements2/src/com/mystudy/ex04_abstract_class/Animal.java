package com.mystudy.ex04_abstract_class;

/* 
추상클래스 : abstract class
	구현 메소드와 추상 메소드가 함께 있는 클래스(추상메소드가 하나라도 있으면)
	추상클래스는 추상메소드가 있어서 객체(인스턴스)를 생성 할 수 없음
 */
abstract class Animal {
	String name = "동물"; //이름, 명칭
	int legCnt; //다리갯수
	
	void eat() {
		System.out.println(">> 먹는다");
	}
	void sleep() {
		System.out.println(">> 잠을잔다");
	}
	
	//추상메소드 : 메소드의 몸체(body, 구현부)가 없는 메소드
	//추상메소드는 명시적으로 abstract 키워드를 붙여야 한다
	abstract void sound();

}














