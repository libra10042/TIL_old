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
	
	//�������̽�(interface) Ÿ������ �����͸� ���޹޾Ƽ� ó��
	static void executeSound(I_Animal animal) {
		//I_Animal.sound() ȣ��
		//���������� �޼ҵ� �������̵��� ���� cat.soun() �����
		animal.sound();
	}

}









