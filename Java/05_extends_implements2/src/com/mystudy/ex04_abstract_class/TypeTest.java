package com.mystudy.ex04_abstract_class;

public class TypeTest {

	public static void main(String[] args) {
		//�߻�Ŭ������ ��ü(�ν��Ͻ�) ������ �� ����
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









