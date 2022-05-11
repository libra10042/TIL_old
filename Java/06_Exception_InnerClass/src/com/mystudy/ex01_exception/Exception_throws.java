package com.mystudy.ex01_exception;

public class Exception_throws {

	public static void main(String[] args) {
		// throws : ���ܸ� ���� ��(����, ����) ���
		// ���ܸ� �߻��� ������ ó������ �ʰ� ���ܸ� ������ �ٸ� ������ ó���ϵ��� ��
		// �޼ҵ带 ȣ���� ������ ó���ϵ��� ���ܸ� ����
		System.out.println("---- main() ���� ----");
		int num1 = 100;
		int num2 = 0;
		int result = 0;
		
		System.out.println(">> ����ó�� ����");
		result = div(num1, num2);
		System.out.println(">>div() ������ : " + result);
		
		System.out.println("==========================");
		result = -999;
		try {
			result = divThrows(num1, num2);
		} catch(ArithmeticException e) {
			//���޹��� ���ܸ� ��Ƽ� ó��
			System.out.println("main() divThrows() ȣ�� ó���� ���ܹ߻�~~");
		}
		
		System.out.println(">>divThrows() ó����� : " + result);
		
		
		System.out.println("---- main() �� ----");
	}
	
	//����ó�����1 : �޼ҵ� ���ο��� ����(Exception)�� ���� ó���� ���
	static int div(int num1, int num2) {
		System.out.println("--->> div() ����");
		int result = Integer.MIN_VALUE;
		try {
			result = num1 / num2;
		} catch(ArithmeticException e) {
			System.out.println("[div���ܹ߻�] " + e.getMessage());
		}
		System.out.println("--->> div() ��");
		return result;
	}
	
	//����ó�����2 : �޼ҵ� ������ �߻��� ����(Exception)�� ���� ó������ �ʰ�
	//    ȣ���� ������ ����ó�� �ϵ��� ����(��)�� ������(throws)
	static int divThrows(int num1, int num2) throws ArithmeticException {
		System.out.println("==> divThrows() ����");
		int result = -1;
		result = num1 / num2;
		
		System.out.println("==> divThrows() ��");
		return result;
	}

}










