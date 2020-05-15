package com.mystudy.ex04_innerclass;

interface TestInter {
	int DATA = 100; //상수
	void printData(); //public abstract (추상메소드)
}

class TestInterImpl implements TestInter {
	@Override
	public void printData() {
		System.out.println("printData() >>> 구현한메소드");
	}
}

public class AnonymousClassTest {
	void test1() {
		System.out.println("--- test1() ---");
		//익명클래스 사용 객체 생성
		//인터페이스 타입의 객체를 생성하고 변수에 저장해서 사용
		TestInter anClass = new TestInter() {
			@Override
			public void printData() {
				System.out.println("익명클래스 printData() DATA : " + DATA);
			}
		};
		anClass.printData();
		anClass.printData();
	}
	
	void test2() {
		//익명클래스 사용 객체 생성 : 인터페이스타입 객체 생성하고 한 번만 사용
		(new TestInter() {
			@Override
			public void printData() {
				System.out.println("익명클래스 printData() DATA : " + DATA);
			}
		}).printData();
	}
	

	public static void main(String[] args) {
		TestInter imp = new TestInterImpl(); //이름을 가진 클래스  TestInterImpl
		imp.printData();
		imp.printData();
		System.out.println("----------");
		(new TestInterImpl()).printData();
		
		System.out.println("===================");
		AnonymousClassTest test = new AnonymousClassTest();
		test.test1();
		
		
	}

}






