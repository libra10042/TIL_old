package com.mystudy.ex05_interface;

public class TypeTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.eat();
		cat.sleep();
		cat.sound();
		
		Dog dog = new Dog();
		dog.eat();
		dog.sleep();
		dog.sound();
		
		System.out.println("------");
		executeSound(cat);
		executeSound(dog);
		
		System.out.println("--- Animal <- Cat ---");
		Animal an = cat;
		executeSound(an);
				
	}
	
	//인터페이스(interface) 타입으로 데이터를 전달받아서 처리
	static void executeSound(I_Animal animal) {
		//I_Animal.sound() 호출
		//실제동작은 메소드 오버라이딩에 따라 cat.soun() 실행됨
		animal.sound();
	}

}









