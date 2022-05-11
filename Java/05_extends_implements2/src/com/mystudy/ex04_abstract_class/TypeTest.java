package com.mystudy.ex04_abstract_class;

public class TypeTest {

	public static void main(String[] args) {
		//추상클래스는 객체(인스턴스) 생성할 수 없음
		//Animal an = new Animal();
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		sound(cat);
		sound(dog);

	}
	
	static void sound(Animal animal) {
		animal.sound();
	}

}









