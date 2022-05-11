package com.mystudy.ex04_innerclass;

public class LocalCalssTest {
	int a = 100;
	
	void innerTest(int k) {
		//����Ŭ�������� ���� ���ú����� �ڵ����� final ó���� 
		int b = 200; //��������(local variable)
		int c = k; 
		int d = 300;
		d = 400;
		//�޼ҵ� ���� ����� Ŭ���� - ����Ŭ����(Local class)
		//������ : ����� �޼ҵ� ���ο����� ��� ����
		class Inner {
			void printData() {
				System.out.println("==> local class�� printData() ����");
				System.out.println("�ܺ� int a : " + a);
				System.out.println("���� int b : " + b);
				System.out.println("�Ķ���� int k : " + k);
				System.out.println("���� int c : " + c);
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
