package com.mystudy.ex02_extends;

class Phone {
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
	
	//��ȭ�ɱ� ���
	public void call() {
		System.out.println(">> Phone ��ȭ�ɱ�~~~~");
	}
	//��ȭ�ޱ� ���
	public void receiveCall() {
		System.out.println(">> Phone ��ȭ�ޱ�");
	}
	//��ȭ���� ����
	public void view() {
		System.out.println("Phone - Ÿ��: " + type + ", ��ȣ: " + phoneNo);
	}
	
}









