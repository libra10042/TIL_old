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
		
		System.out.println("=== sound() �޼ҵ� ȣ�� ���� ===");
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
	//���ο� ������ Ÿ���� �߰��Ǹ� �ҽ��ڵ� �߰� �۾� �ʿ�
	static void sound(Animal animal) {
		System.out.println(">>> sound(Animal) ����");
		
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











