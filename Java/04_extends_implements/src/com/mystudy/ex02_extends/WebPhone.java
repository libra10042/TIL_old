package com.mystudy.ex02_extends;

/*(�ǽ�) Ŭ���� ���(extends) �����ؼ� Ŭ���� �����
�ǽ�1: Phone Ŭ���� ��� Ȯ��(extends)
WebPhone Ŭ���� �ۼ�
	- Phone Ŭ���� ��� Ȯ���ؼ� �����
	- ������ ����
		* ����ȣ(phoneNo)�� �޾Ƽ� ��ü(�ν��Ͻ�) ����
		* Ÿ�� ���� "WebPhoneŸ��"���� �ۼ�
	- ��� : ��ȭ�ɰ�, �ް�, ��������, ���˻� 
	- ���˻� ���
		webSearch() : ">> WebPhone - �� �˻�" ���� ȭ�� ���
*/
class WebPhone extends Phone {
	
	//������ --------
	public WebPhone(String phoneNo) {
		super("WebPhoneŸ��", phoneNo);
	}
	public WebPhone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	//���˻����
	public void webSearch() {
		System.out.println(">> WebPhone - �� �˻�");
	}
}









