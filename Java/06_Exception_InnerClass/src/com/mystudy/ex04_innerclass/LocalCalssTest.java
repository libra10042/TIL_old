package com.mystudy.ex04_innerclass;

public class LocalCalssTest {
	int a = 100;
	
	void innerTest(int k) {
		//로컬클래스에서 사용된 로컬변수는 자동으로 final 처리됨 
		int b = 200; //지역변수(local variable)
		int c = k; 
		int d = 300;
		d = 400;
		//메소드 내에 선언된 클래스 - 지역클래스(Local class)
		//사용범위 : 선언된 메소드 내부에서만 사용 가능
		class Inner {
			void printData() {
				System.out.println("==> local class의 printData() 실행");
				System.out.println("외부 int a : " + a);
				System.out.println("로컬 int b : " + b);
				System.out.println("파라미터 int k : " + k);
				System.out.println("로컬 int c : " + c);
			}
		}
		Inner in = new Inner();
		in.printData();
	}
	
	public static void main(String[] args) {
		LocalCalssTest outer = new LocalCalssTest();
		outer.innerTest(999);

	}

}
