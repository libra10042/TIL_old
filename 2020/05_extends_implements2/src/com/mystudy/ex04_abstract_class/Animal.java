package com.mystudy.ex04_abstract_class;

/* 
�߻�Ŭ���� : abstract class
	���� �޼ҵ�� �߻� �޼ҵ尡 �Բ� �ִ� Ŭ����(�߻�޼ҵ尡 �ϳ��� ������)
	�߻�Ŭ������ �߻�޼ҵ尡 �־ ��ü(�ν��Ͻ�)�� ���� �� �� ����
 */
abstract class Animal {
	String name = "����"; //�̸�, ��Ī
	int legCnt; //�ٸ�����
	
	void eat() {
		System.out.println(">> �Դ´�");
	}
	void sleep() {
		System.out.println(">> �����ܴ�");
	}
	
	//�߻�޼ҵ� : �޼ҵ��� ��ü(body, ������)�� ���� �޼ҵ�
	//�߻�޼ҵ�� ��������� abstract Ű���带 �ٿ��� �Ѵ�
	abstract void sound();

}














