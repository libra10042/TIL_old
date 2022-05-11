package com.mystudy.ex05_interface3;
/*
�������̽� �������(Java8 ����)
	- ������� : public static final ����
	- �߻�޼ҵ� : public abstract �޼ҵ�
Java8(JDK8)���� �߰��� ���
	- public default �޼ҵ� : ��� ���� ����(default �޼ҵ�)
	- public static �޼ҵ� : ��� ���� ����(static �޼ҵ�)
*/

public interface I_Phone {
	//���ȭ�� ���� : �������̽��� ���ǵ� ��� ������ public static final ����
	public static final boolean SUCCESS_CALL = true;
	boolean FAIL_CALL = true; //public static final ���� ����
	
	//public abstract : �߻�޼ҵ�(abstract method)
//	public abstract String getType();
//	public String getPhoneNo(); //abstract ������
	
	public abstract void call(); //public abstract ������
	public void receiveCall(); //public abstract ������
	void view(); //public abstract ������
	
	//----------------------------------------
	//default �޼ҵ�
	public default void changeNo(String PhoneNo) {
		//�̹� ������ �޼ҵ�� �ʿ��ϸ� ������ �ϰ�, �ʿ������ ���� ���ص� ��
	}
	
	//static �޼ҵ�
	public static void staticMethod() {
		System.out.println("I_Phone �������̽��� static �޼ҵ�~~~");
	}
}











