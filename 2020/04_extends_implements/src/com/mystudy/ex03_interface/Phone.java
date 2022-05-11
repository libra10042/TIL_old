package com.mystudy.ex03_interface;
/* ��ȭ�� Ŭ���� �����
	�Ӽ� : Ÿ��(type), ��ȭ��ȣ(phoneNo)
	���
	- ��ȭ ���� Ȯ�α��(view)
	- ��ȭ�ɱ�(call)
	- ��ȭ�ޱ�(receiveCall)
	- �޽��� ������ : ">> �޽��� ����" ȭ�����
	- �޽��� �ޱ� : ">> �޽��� ����" ȭ�����
*/
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
	
	//----------------------------
	//�޽��� ������
	public void sendMessage() {
		System.out.println(">> �޽��� ����");
	}
	//�޽��� �ޱ�
	public void receiveMessage() {
		System.out.println(">> �޽��� ����");
	}
}










