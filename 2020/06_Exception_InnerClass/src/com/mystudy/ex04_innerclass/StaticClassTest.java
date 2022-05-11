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
	
	//����ƽ ���� Ŭ����(Inner Ŭ���� �� static Ŭ����)
	static class Inner {
		static int d = 1000;
		int e = 2000;
		void printData() {
			System.out.println("===> static innerŬ���� printData() ����");
			//System.out.println("int a : " + a); //a : non-static
			//System.out.println("private int b : " + b); //b : non-static
			System.out.println("static int c : " + c); //c : static
			System.out.println("inner static int d : " + d); //d : static
			System.out.println("inner int e : " + e);
		}
	}
	
	public static void main(String[] args) {
		//����ƽ ������ ��� : Ŭ������.������
		int num = StaticClassTest.c;
		//����ƽ �޼ҵ� ���
		StaticClassTest.sum();
		
		//static ���� Ŭ������ static �ʵ庯�� ���
		int innerNum = StaticClassTest.Inner.d;
		
		//static ���� Ŭ������ non-static �ʵ�, �޼ҵ� ��� -------------
		StaticClassTest.Inner inner = new StaticClassTest.Inner();
		inner.printData();

	}

}









