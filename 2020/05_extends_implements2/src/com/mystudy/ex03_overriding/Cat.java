package com.mystudy.ex03_overriding;

public class Cat extends Animal {

	void sound() {
		System.out.println(">> �߿�~");
	}
	@Override
	public String toString() {
		System.out.println(">> ���� �����");
		return "�����";
	}
}
