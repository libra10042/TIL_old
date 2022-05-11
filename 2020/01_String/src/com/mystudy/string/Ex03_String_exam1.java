package com.mystudy.string;

public class Ex03_String_exam1 {

	public static void main(String[] args) {
		/* (�ǽ�) String Ŭ������ �޼ҵ带 ���
		String str = "940108-1234567"; //�ֹε�Ϲ�ȣ ü��
		1. ��Ȯ�� �Էµ� ����Ÿ���� Ȯ��
		   (��ü�ڸ���: 14 �ڸ�, '-'��ġ : 7��°���� Ȯ��)
		2. ������� ���(1-2��°: �⵵, 3-4��°: ��, 5-6��°: ��)
			��)900108 -> 90�� 01�� 08�� �Ǵ� 90�� 1�� 8��
		3. ����Ȯ���ϰ� ���(1,3: ����, 2,4: ����)
		4. ����Ÿ �� ����(��: 1~12, ��: 1~31)
		���� : int num = Integer.parseInt("12") : "12" -> 12(���ڿ�->����)
		-------------------------------------*/
		String str = "940108-1234567";
		System.out.println("str : " + str);
		
		//1. ��Ȯ�� �Էµ� ����Ÿ���� Ȯ��
		//��ü�ڸ���: 14 �ڸ�
		System.out.println("str.length() : " + str.length());
		int length = str.length();
		if (length == 14) {
			System.out.println("[����] ��ü���� 14�ڸ�");
		} else {
			System.out.println("[������] ��ü���� " + str.length());
			System.out.println(">> �߸��� ����Ÿ�� �ԷµǾ� ���α׷� ����!!");
			//return;
		}
		
		//'-'��ġ : 7��°���� Ȯ��(charAt, indexOf, substring)
		System.out.println("str.charAt(6) : " + str.charAt(6));
		if (str.charAt(6) == '-') {
			System.out.println("[����] '-' ������ġ 7��°");
		} else {
			System.out.println("[����] '-' ������ġ 7��° �ƴ�");
		}
		
		//'-'��ġ : 7��°���� Ȯ��(indexOf)
		System.out.println(str.indexOf('-'));
		if (str.indexOf('-') != 6) { //�������� ���
			System.out.println("[������] '-' ������ġ 7��° �ƴ�");
		}
		//'-'��ġ : 7��°���� Ȯ��(substring)
		System.out.println(str.substring(6, 7));
		if (str.substring(6, 7).equals("-")) {
			System.out.println("[����substring] '-' ������ġ 7��°");
		} else {
			System.out.println("[����substring] '-' ������ġ 7��° �ƴ�");
		}
		
		//2. ������� ���(1-2��°: �⵵, 3-4��°: ��, 5-6��°: ��)
		//	��)900108 -> 90�� 01�� 08�� �Ǵ� 90�� 1�� 8��
		//String str = "940108-1234567";
		String yymmdd = str.substring(0, 6);
		System.out.println("yymmdd : " + yymmdd);
		String yy = yymmdd.substring(0, 2);
		String mm = yymmdd.substring(2, 4);
		String dd = yymmdd.substring(4, 6);
		
		System.out.println("������� : " + yy +"�� "+ mm +"�� "+ dd +"��");
		
		//3. ����Ȯ���ϰ� ���(1,3: ����, 2,4: ����) --------------------
		String gender = str.substring(7, 8);
		System.out.println("���� : " + gender);
		//if (gender.equals("1") || "3".equals(gender)) {
		if ("1".equals(gender) || "3".equals(gender)) {
			System.out.println("�ֹι�ȣ ���ڸ�(ù����) : " + gender + "(����)");
		} else if ("2".equals(gender) || "4".equals(gender)) {
			System.out.println("�ֹι�ȣ ���ڸ�(ù����) : " + gender + "(����)");
		} else {
			System.out.println("[������] �ֹι�ȣ ���ڸ�(ù����) : " + gender);
		}
		
		switch (gender) {
		case "1": case "3":
			System.out.println("�ֹι�ȣ ���ڸ�-ù���� : " + gender + "(����)");
			break;
		case "2": case "4":
			System.out.println("�ֹι�ȣ ���ڸ�-ù���� : " + gender + "(����)");
			break;
		default:
			System.out.println("�ܱ���????");
		}
		
		System.out.println("=========================");
		//4. ����Ÿ �� ����(��: 1~12, ��: 1~31) ------------------------
		//              0123456
		//String str = "940108-1234567";
		String sMonth = str.substring(2, 4);
		System.out.println("str.substring(2, 4) : " + str.substring(2, 4));
		int month = Integer.parseInt(sMonth);
		if (month >= 1 && month <= 12) {
			System.out.println("[����] �� ����Ÿ(1~12)");
		} else {
			System.out.println("[������] �� ����Ÿ 1~12 ������ �ƴ�");
		}
		if (month < 1 || month > 12) {
			System.out.println("[������] �� ����Ÿ 1~12 ������ �ƴ�");
		}

		//����Ȯ�� : 1~31 ��������
		int date = Integer.parseInt(str.substring(4, 6));
		if (date >= 1 && date <= 31) {
			System.out.println("[����] �� ����Ÿ(1~31)");
		} else {
			System.out.println("[������] �� ����Ÿ 1~31 ���� �ƴ�");
		}
		
		
		System.out.println("--- main() ���� ---");
	}

}














