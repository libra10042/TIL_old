package com.mystudy.ex03_sungjuk;

public class SungjukTest {

	public static void main(String[] args) {
		// StudentVO Ÿ���� ������ 1�� ���� �� ��������, �������� ����
		System.out.println("--- main() ���� ---");
		StudentVO stu = new StudentVO("ȫ�浿", 100, 90, 80);
		System.out.println(stu.toString());
		
		boolean result = stu.setKor(90); //�߸��� ���� �Է�
		if (!result) {
			System.out.println("[���ܹ߻�] ���� ����" );
		}
		System.out.println("�������: " + stu.toString());
		
		System.out.println("====================");
		System.out.println("--- setEng() ó�� ---");
		
		try {
			stu.setEng(888);
		} catch (JumsuOutOfRangeException e) {
			System.out.println("[���ܹ߻�] " + e.getMessage());
		} catch (SungjukProcessException e) {
			System.out.println("[���ܹ߻�] ����ó���� ���� �߻�");
		} catch (Exception e) {
			System.out.println("[���ܹ߻�] ���� �߻�");
		}
		System.out.println("����������: " + stu);
		
		System.out.println("--- main() �� ---");
	}

}











