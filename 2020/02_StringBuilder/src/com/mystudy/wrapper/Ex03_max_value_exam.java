package com.mystudy.wrapper;

public class Ex03_max_value_exam {

	public static void main(String[] args) {
		// ���� 3�� �� ���� ū ���� ���Ͻÿ�
		int a = 40;
		int b = 1000;
		int c = 9999;
		
		//if�� ���
		if (a > b) { //a�� ū ���
			if (a > c) {//a�� ū ���
				System.out.println("�ִ밪 : " + a);
			} else {//c�� ū ���
				System.out.println("�ִ밪 : " + c);
			}
		} else if (b > c) {
			System.out.println("�ִ밪 : " + b);
		} else {
			System.out.println("�ִ밪 : " + c);
		}
		
		System.out.println("==== �ִ밪 ���� ��� ===");
		int max = Integer.MIN_VALUE;
		if (a > max) {
			max = a;
		}
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		System.out.println("�ִ밪 : " + max);

	}

}








