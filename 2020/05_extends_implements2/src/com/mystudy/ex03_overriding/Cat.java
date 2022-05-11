package com.mystudy.ex03_overriding;

public class Cat extends Animal {

	void sound() {
		System.out.println(">> 야옹~");
	}
	@Override
	public String toString() {
		System.out.println(">> 나는 고양이");
		return "고양이";
	}
}
