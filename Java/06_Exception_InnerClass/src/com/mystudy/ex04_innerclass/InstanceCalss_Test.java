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
	
	//����Ŭ���� : �ν��Ͻ� Ŭ����
	class Inner {
		int in = 100;
		void printData() {
			System.out.println(">>> ����Ŭ������ printData() ����~~");
			System.out.println("int a : " + a);
			System.out.println("private int b : " + b);
			System.out.println("static int c : " + b);
			sum();
			System.out.println("sum : " + sum);
			
			System.out.println("����Ŭ���� �ʵ� in : " + in);
		}
	}
	
	
	public static void main(String[] args) {
		InstanceCalss_Test out = new InstanceCalss_Test();
		System.out.println("�ʵ庯�� a : " + out.a);
		
		System.out.println("--- ����Ŭ����(�ν��Ͻ�Ŭ����) ��� ---");
		//����Ŭ������ �ִ� printData() �����ϱ�
		//Inner Ŭ������ ��ü ����
		//�ܺ�Ŭ���� ��ü�� ���ؼ� ����
		// ����Ŭ���� Ÿ�� : �ܺ�Ŭ����.����Ŭ������
		// ����Ŭ���� ��ü���� : new �ܺ�Ŭ����().new Inner(); 
		//		- �ܺ�Ŭ���� ��ü ���� �� ���� Ŭ���� ��ü ����
		
		InstanceCalss_Test.Inner inner 
				= new InstanceCalss_Test().new Inner();
		inner.printData();

	}

}













