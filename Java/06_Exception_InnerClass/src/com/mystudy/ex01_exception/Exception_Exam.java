package com.mystudy.ex01_exception;

public class Exception_Exam {

	public static void main(String[] args) {
		System.out.println("--- main() ���� ---");
		int num = 100;
		int num1 = 10;
		int result = 0;
		System.out.println(">> �������");
		//result = num / num1;
		//����ó�� -----------
		if (num1 == 0) {
			System.out.println("[���ܹ߻�] ������ ���� 0�Դϴ�");
		} else {
			result = num / num1;
			System.out.println("result : " + result);
		}
		
		//-------------------------------------------
		System.out.println("--- ����ó�� try ~ catch ----");
		try {
			result = num / num1;
			System.out.println("result : " + result);
		} catch(ArithmeticException ex) {
			System.out.println("[���ܹ߻� �޽���] " + ex.getMessage());
			//ex.printStackTrace();
		} catch(Exception ex) {
			System.out.println("[���ܹ߻�] ������ ���� 0�Դϴ�");
		} finally { //�������, ���ܹ߻� �� ��� ��쿡 ������ ����Ǵ� ����
			System.out.println(">> finally ������ ����");
		}
		
		
		System.out.println("--- main() �� ---");
	}

}








