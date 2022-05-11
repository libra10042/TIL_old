package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam2_Sungjuk {

	public static void main(String[] args) {
		// ����, ����, ����, ���� ������ ȭ��(�ܼ�)���� �Է¹޾�
		// ����, ����� ���ϰ� ��� ȭ�� ���
		// (�� �� ���� �� ���������� �ݺ� ó��)
		/*
		���� : ȫ�浿
		���� : 100
		���� : 90
		���� : 81
		----------
		���� : 271
		��� : 90.33
		***********************/
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			//ȭ�鿡�� ������ �Է� �ޱ�
			System.out.print("���� : ");
			String name = scan.nextLine();
			
			int kor = inputScore(scan, "����");
//			System.out.print("�������� : ");
//			int kor = scan.nextInt();
			
			System.out.print("�������� : ");
			int eng = scan.nextInt();
			
			System.out.print("�������� : ");
			int math = scan.nextInt();
			scan.nextLine();
			
			//�Է°��� ���� ��� ó��
			int tot = kor + eng + math;
			double avg = tot * 100 / 3 / 100.0;
			
			//���� ��� ���
			System.out.println("\n=== ���� ��� ===");
			System.out.println("���� : " + name);
			System.out.println("���� : " + kor);
			System.out.println("���� : " + eng);
			System.out.println("���� : " + math);
			System.out.println("-----------");
			System.out.println("���� : " + tot);
			System.out.println("��� : " + avg);
			System.out.println("==============");
			System.out.println();
		
			//����ó�� ��� ���� Ȯ��
			System.out.print("��� �۾� �Ͻðڽ��ϱ�?(y:����۾�, n:�ߴ�) ");
			String answer = scan.nextLine();
			if ("N".equalsIgnoreCase(answer)) {
				System.out.println(">> �۾��� ����Ǿ����ϴ�.");
				break;
			}
			System.out.println(">> ����ó���� ����մϴ�. �����͸� �Է��ϼ���~~");
		}
	}
	
	static int inputScore(Scanner scan, String subject) {
		int result = -1;
		
		while (true) {
			System.out.print(subject + "���� : ");
			try {
				result = Integer.parseInt(scan.nextLine());
				if (result < 0 || result > 100) {
					System.out.println("[����] ����(0~100) ��� ���Դϴ�. �ٽ� �Է��ϼ���.");
					continue;
				}
				break; //�������� ���ڰ� �ԷµǸ�
			} catch(Exception e) {
				System.out.println("[���ܹ߻�] �߸��� ���Դϴ�. �ٽ� �Է��ϼ���");
			}
		}
		
		return result;
	}

}













