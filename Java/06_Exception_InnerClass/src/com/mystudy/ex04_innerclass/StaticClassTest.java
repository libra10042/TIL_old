package com.mystudy.ex04_innerclass;

public class StaticClassTest {
	int a = 10;
	private int b = 100;
	
	static int c = 200;
	static int sum = 0;
	static int sNum1 = 20;
	static int sNum2 = 30;
	
	static void sum() {
		sum = Inner.d + sNum2;
	}
	
	//스테틱 내부 클래스(Inner 클래스 중 static 클래스)
	static class Inner {
		static int d = 1000;
		int e = 2000;
		void printData() {
			System.out.println("===> static inner클래스 printData() 실행");
			//System.out.println("int a : " + a); //a : non-static
			//System.out.println("private int b : " + b); //b : non-static
			System.out.println("static int c : " + c); //c : static
			System.out.println("inner static int d : " + d); //d : static
			System.out.println("inner int e : " + e);
		}
	}
	
	public static void main(String[] args) {
		//스태틱 변수값 사용 : 클래스명.변수명
		int num = StaticClassTest.c;
		//스테틱 메소드 사용
		StaticClassTest.sum();
		
		//static 내부 클래스의 static 필드변수 사용
		int innerNum = StaticClassTest.Inner.d;
		
		//static 내부 클래스의 non-static 필드, 메소드 사용 -------------
		StaticClassTest.Inner inner = new StaticClassTest.Inner();
		inner.printData();

	}

}









