package com.mystudy.ex03_overriding;

public class TypeTest {

	public static void main(String[] args) {
		Animal an = new Animal(); 
		an.eat();
		an.sleep();

		Cat cat = new Cat();
		cat.sound();
		
		Dog dog = new Dog();
		dog.sound();
		
		Pig pig = new Pig();
		pig.sound();
		
		System.out.println("=== sound() 메소드 호출 실행 ===");
		sound(cat);
		sound(dog);
		sound(pig);
		
		Chicken chicken = new Chicken();
		sound(chicken);
		
		System.out.println("==== Animal <- Cat ===");
		Animal an2 = new Cat();
		sound(an2);
		
		System.out.println("========================");
		System.out.println("cat : " + cat);
		System.out.println("dog : " + dog);
		
	}
	
	static void sound(Animal animal) {
		animal.sound();
	}
	
/*	
	//새로운 데이터 타입이 추가되면 소스코드 추가 작업 필요
	static void sound(Animal animal) {
		System.out.println(">>> sound(Animal) 실행");
		
		if (animal instanceof Cat) {
			((Cat)animal).sound();
		} else if (animal instanceof Dog) {
			((Dog)animal).sound();
		} else if (animal instanceof Pig) {
			((Pig)animal).sound();
		}
	}
*/	

}











