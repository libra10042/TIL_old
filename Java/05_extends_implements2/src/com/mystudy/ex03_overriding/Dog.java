package com.mystudy.ex03_overriding;

public class Dog extends Animal {
	
	@Override
	void sound() {
		System.out.println(">> ��~~ ��~~");
	}
	
	//�޼ҵ� �������̵�� �������� ����(�Ķ���� ���°� �ٸ�)
	void sound(String str) {
		System.out.println(str + ">> ��~~ ��~~");
	}
}
