package com.mystudy.ex05_interface;

public abstract class Animal implements I_Animal {

	@Override
	public void eat() {
		System.out.println(">> �Ա�");
	}
	@Override
	public void sleep() {
		System.out.println(">> ���ڱ�");
	}

	@Override
	public abstract void sound();
	
}










