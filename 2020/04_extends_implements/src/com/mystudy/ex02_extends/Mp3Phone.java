package com.mystudy.ex02_extends;

// Phone Ŭ������ ��ӹ޾�(extends - Ȯ���ؼ�) Mp3Phone �����
class Mp3Phone extends Phone {

	public Mp3Phone(String phoneNo) {
		/*
		 * ��������� �θ�Ŭ������ ������ ȣ���� ���� �ʴ� ���
		 * �����Ϸ��� super(); �ڵ带 �������� ���� ù��° �ٿ� �ۼ��ؼ� ������ ����
		 */
		//super(); //super() : �θ�Ŭ������ �⺻������ �ڵ�ȣ�� �ڵ尡 ���Ե�
		
		// super : �θ�Ŭ����, super() : �θ�Ŭ������ ������
		super("Mp3PhoneŸ��", phoneNo);
	}
	
	//��ȭ�ɱ� ��� �޼ҵ� �ۼ�
	public void playMusic() {
		System.out.println(">> Mp3Phone - �����÷���");
	}


}









