package com.mystudy.ex04_interface2;

//(�ǽ�)�������̽�(interface) ����(implements)�ϴ� ������� Ŭ���� �����
// I_Phone �������̽� ���
/* ��ȭ�� Ŭ���� �����
�Ӽ� : Ÿ��(type), ��ȭ��ȣ(phoneNo)
���
- ��ȭ ���� Ȯ�α��(view)
- ��ȭ�ɱ�(call)
- ��ȭ�ޱ�(receiveCall)
- �޽��� ������ : ">> �޽��� ����" ȭ�����
- �޽��� �ޱ� : ">> �޽��� ����" ȭ�����
*/
public class Phone implements I_Phone {
	//�ʵ�(�Ӽ�) --------
	private String type; //��ȭ��Ÿ��(����,��Ī)
	private String phoneNo; //��ȭ��ȣ
	
	//������ --------
	public Phone(String phoneNo) {
		this.type = "Phone Ÿ��";
		this.phoneNo = phoneNo;
	}
	public Phone(String type, String phoneNo) {
		super(); //�θ�Ŭ������ �⺻������ ȣ��
		this.type = type;
		this.phoneNo = phoneNo;
	}
	
	//�޼ҵ�(���) ------
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	@Override //�޼ҵ� ������(����Ŭ����, �������̽� �޼ҵ� ������)
	public void call() {
		System.out.println(">> Phone ��ȭ�ɱ�~~~~");
	}
	@Override
	public void receiveCall() {
		System.out.println(">> Phone ��ȭ�ޱ�");
	}
	@Override
	public void view() {
		System.out.println("Phone - Ÿ��: " + type + ", ��ȣ: " + phoneNo);
	}
	@Override
	public void sendMsg() {
		System.out.println(">> �޽��� ����");
	}
	@Override
	public void receiveMsg() {
		System.out.println(">> �޽��� ����");
	}

	
	
}













