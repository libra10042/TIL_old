package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam1 {

	public static void main(String[] args) {
		// Scanner : �ַ� �ܼ�(ȭ��)���� ���� �Է¹޾� ó���� �� ���
		Scanner scan = new Scanner(System.in);
		
		//inputString(scan);
		
		System.out.println("=========================");
//		int num1 = 100;
//		int num2 = 200;
//		int sum = num1 + num2;
//		System.out.println("sum : " + sum);
		
		System.out.print("> ���� �Է�1 : ");
		int num1 = scan.nextInt();
		
		System.out.print("> ���� �Է�2 : ");
		int num2 = scan.nextInt();
		
		int sum = num1 + num2;
		System.out.println("�հ��� : " + sum);
		
		System.out.println("==================");
		//���� : nextInt(), nextLine()�޼ҵ� ���ӻ��� �����߻�
		//     nextLine()�� ���� ���� ���ϴ� �����߻�
		System.out.print(">> �����Է� : ");
		int num3 = scan.nextInt();
		scan.nextLine(); //�ٹٲ� ���� ���ʱ��� �б�(�ٹٲ� �������� �б�)
		
		System.out.print(">> ���ڿ�(����) �Է� : ");
		int num4 = Integer.parseInt(scan.nextLine());
		
		System.out.println();
		System.out.println("num3: " + num3 + ", num4: " + num4);
		sum = num3 + num4;
		System.out.println("num3 + num4 : " + sum);
		
		System.out.println("\n--- main() �� ---");
	}
	
	static void inputString(Scanner scan) {
		System.out.print("���ڿ� �Է�1 : ");
		String str1 = scan.nextLine();
		System.out.println(">>> " + str1);
		
		System.out.println("-----");
		System.out.print("���ڿ� �Է�2 : ");
		String str2 = scan.nextLine();
		System.out.println(">>> " + str2);
	}

}











