package com.mystudy.ex03_interface;

//�������̽� : �߻�ü
public interface I_Phone {
	/* �������̽� ����� �߻�޼ҵ�(abstract method)
	 * public abstract �޼ҵ���
	 */
	public abstract void call();
	public void receiveCall(); //abstract ��������
	void view(); //public abstract ��������
	
	void sendMsg(); //public abstract �޼ҵ�
	void receiveMsg(); //public abstract �޼ҵ�
}







