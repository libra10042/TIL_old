package com.mystudy.ex04_printwriter;

import java.util.Calendar;

public class Exam_printf {

	public static void main(String[] args) {
		// printf() �޼ҵ�
		int a = 20;
		long b = 300000000000L;
		float c = 34.95f;
		double d = 234.234;
		char e = 'A';
		String f = "Hello~~~";
		boolean g = false;
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.printf("%tF", today);
		System.out.println();
		
		System.out.println("---------------");
		System.out.println(">> " + a + " " + b + " " + c + " "
				+ d + " " + e + " " + f + " " + g);
		
		System.out.println("====== printf ���� ======");
		/* printf �޼ҵ��� ���� ���� �ۼ� ���([] �ɼ� ��������)
		%[�ε���]$[-][ũ��]���Ĺ��� : %, ���Ĺ��� �ʼ� �ۼ�
		- ������ �⺻������ ��������
		- �������� ����� ���̳ʽ� ��ȣ ��� : ��) %-10d
		*/
		System.out.printf("%d %d %f %f \n", a, b, c, d);
		System.out.printf("%c %s %b %n", e, f, g);
		System.out.printf("%d %d %c %s \n", 100, 100, 'A', "Hllo~");
		
		//%[�ε���]$[-][ũ��]���Ĺ��� : %, ���Ĺ��� �ʼ� �ۼ�
		System.out.println("---- �ε��� ��뿹 ----");
		//System.out.printf("%d %d \n", 65); //1 �� 1 ��Ī���� ������ ���� ���ܹ߻�
		//(����) ��ġ�� �ε��� �����ϸ� ������ ��Ī���� ���ܵ�
		System.out.printf("%1$d %1$d %c %s\n", 67, 'B', "Hello~~");
		System.out.printf("%1$d %1$d %2$c %3$s\n", 67, 'B', "Hello~~");
		System.out.printf("%1$d %1$d %3$s %2$c \n", 67, 'B', "Hello~~");
		
		System.out.println("------ �Ǽ��� ������ --------");
		System.out.printf("%f %1$a %1$e %1$g \n", 65.1234567890123);
		System.out.println("123456789012345");
		System.out.printf("%1$10.4f\n", 65.1234567890123); //��ü 10�ڸ� �Ҽ������� 4�ڸ�
		System.out.printf("%1$-10.4f\n", 65.1234567890123); //�������� ��ü 10�ڸ� �Ҽ������� 4�ڸ�
		
		System.out.println("------ ��¥���� -----");
		System.out.printf("%1$tY/%1$tm/%1$td \n", today);
		System.out.printf("%1$tF \n", today);
		System.out.printf("%1$tI:%1$tM:%1$tS \n", today);
		
		System.out.println("----- ��(width) ���� ----");
		System.out.printf("%1$20f \n", 5678.12345678901234);
		System.out.printf("%1$-20f \n", 5678.12345678901234);
		System.out.printf("%1$-20.10f \n", 5678.12345678901234);
		
		System.out.println("---------------");
		System.out.printf("%-10s %10d %10d %10d \n", "aaaaaa", 100, 90, 80);
		System.out.printf("%-10s %10d %10d %10d \n", "bbbbb", 100, 90, 80);
		System.out.printf("%-10s %10d %10d %10d \n", "ȫ�浿", 100, 90, 80);
		System.out.printf("%-10s %10d %10d %10d \n", "��������", 100, 90, 80);
		
	}

}
















