package com.mystudy.ex04_interface2;

//��ȭ�ɱ�, ��ȭ�ޱ�, ���ں�����, ���ڹޱ�, ��ȭ����Ȯ�� : Phone ���
//�����÷��� : Mp3Phone �������
//���˻� ��ɱ��� ����

/* �������̽� ������ �������� ���Ȯ��(extends)�ؼ� ����� �� ����
 */
public interface I_WebPhone extends I_Phone, I_Mp3Phone {
	// I_Phone ���ǵ� �޼ҵ� ��� ����(���Ȯ�� ��� extends)
	
	// I_Mp3Phone ���ǵ� �޼ҵ� ��� ����(���Ȯ�� ��� extends)
	
	//�� �˻� ���
	void webSearch();
}













