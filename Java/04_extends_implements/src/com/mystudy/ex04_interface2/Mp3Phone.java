package com.mystudy.ex04_interface2;

//��ȭ�ɱ�, ��ȭ�ޱ�, ���ں�����, ���ڹޱ�, ��ȭ����Ȯ�� : Phone ���
//�����÷��� : Mp3Phone �������
//(�ǽ�) Phone Ŭ���� ��� Ȯ���ؼ� ����ϰ� I_Mp3Phone �������̽��� �����ؼ� �����
public class Mp3Phone extends Phone 
	                  implements I_Mp3Phone {

	public Mp3Phone(String phoneNo) {
		super("Mp3PhoneŸ��", phoneNo);
	}
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	@Override
	public void playMusic() {
		System.out.println(">>Mp3Phone �����÷���~~");
	}
}

















