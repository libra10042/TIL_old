package com.mystudy.ex04_innerclass;

interface TestInter {
	int DATA = 100; //���
	void printData(); //public abstract (�߻�޼ҵ�)
}

class TestInterImpl implements TestInter {
	@Override
	public void printData() {
		System.out.println("printData() >>> �����Ѹ޼ҵ�");
	}
}

public class AnonymousClassTest {
	void test1() {
		System.out.println("--- test1() ---");
		//�͸�Ŭ���� ��� ��ü ����
		//�������̽� Ÿ���� ��ü�� �����ϰ� ������ �����ؼ� ���
		TestInter anClass = new TestInter() {
			@Override
			public void printData() {
				System.out.println("�͸�Ŭ���� printData() DATA : " + DATA);
			}
		};
		anClass.printData();
		anClass.printData();
	}
	
	void test2() {
		//�͸�Ŭ���� ��� ��ü ���� : �������̽�Ÿ�� ��ü �����ϰ� �� ���� ���
		(new TestInter() {
			@Override
			public void printData() {
				System.out.println("�͸�Ŭ���� printData() DATA : " + DATA);
			}
		}).printData();
	}
	

	public static void main(String[] args) {
		TestInter imp = new TestInterImpl(); //�̸��� ���� Ŭ����  TestInterImpl
		imp.printData();
		imp.printData();
		System.out.println("----------");
		(new TestInterImpl()).printData();
		
		System.out.println("===================");
		AnonymousClassTest test = new AnonymousClassTest();
		test.test1();
		
		
	}

}






