package com.mystudy.ex05_interface;

public abstract class Animal implements I_Animal {

	@Override
	public void eat() {
		System.out.println(">> 먹기");
	}
	@Override
	public void sleep() {
		System.out.println(">> 잠자기");
	}

	@Override
	public abstract void sound();
	
}










