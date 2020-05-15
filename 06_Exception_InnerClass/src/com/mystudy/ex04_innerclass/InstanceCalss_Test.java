package com.mystudy.ex04_innerclass;

class A {}

public class InstanceCalss_Test {
	int a = 100;
	private int b = 10;
	static int c = 200;
	int sum = 0;
	
	void sum() {
		sum = a + b;
	}
	
	//내부클래스 : 인스턴스 클래스
	class Inner {
		int in = 100;
		void printData() {
			System.out.println(">>> 내부클래스의 printData() 실행~~");
			System.out.println("int a : " + a);
			System.out.println("private int b : " + b);
			System.out.println("static int c : " + b);
			sum();
			System.out.println("sum : " + sum);
			
			System.out.println("내부클래스 필드 in : " + in);
		}
	}
	
	
	public static void main(String[] args) {
		InstanceCalss_Test out = new InstanceCalss_Test();
		System.out.println("필드변수 a : " + out.a);
		
		System.out.println("--- 내부클래스(인스턴스클래스) 사용 ---");
		//내부클래스에 있는 printData() 실행하기
		//Inner 클래스의 객체 생성
		//외부클래스 객체를 통해서 접근
		// 내부클래스 타입 : 외부클래스.내부클래스명
		// 내부클래스 객체생성 : new 외부클래스().new Inner(); 
		//		- 외부클래스 객체 생성 후 내부 클래스 객체 생성
		
		InstanceCalss_Test.Inner inner 
				= new InstanceCalss_Test().new Inner();
		inner.printData();

	}

}













