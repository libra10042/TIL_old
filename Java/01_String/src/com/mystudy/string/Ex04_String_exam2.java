package com.mystudy.string;

import java.util.Arrays;

public class Ex04_String_exam2 {

	public static void main(String[] args) {
		/* String ��� �ǽ�
		���ڿ� : "ȫ�浿","�̼���","�̼���","��������","������","�����ҹ�","Tom","TOM"
		/////////-�迭 �����߰�ȣ�� �������ֱ�
		1. ���� ���ڿ� ���� ������ �� �ִ� ���ڿ� �迭(names) ������ �����ϰ� �Է�
		2. �迭�� �ִ� ���� ������ �޸�(,)�� �����Ͽ� �� ���ο� ���
		   ��� ��) ȫ�浿,�̼���,�̼���,��������....
		3. �迭�� �ִ� ����Ÿ�� ù ���ڸ� ���-������ �޸�(,) ��� �� ���ο� ���
		   ��� ��) ȫ,��,��,��,��,��,T,T...
		4. �̸��� ���ڼ��� 4���� �̻��� �̸��� �˻��ؼ� "�ε�����ȣ:�̸�" ���·� ���
		   ��) 3(�ε�����ȣ):��������
		5. �̸��� ���� �����͸� "�ε�����ȣ:�̸�=�ε�����ȣ:�̸�" ���·� ���
		   ��) 1:�̼���=2:�̼���
		(��Ÿ) �̸� �񱳽ÿ��� ��ҹ��� ���� ���� ��ó��(Tom, TOM �� ����)
		========================================================= */
		//1. ���� ���ڿ� ���� ������ �� �ִ� ���ڿ� �迭(names) ������ �����ϰ� �Է�
//		String[] names = new String[8];
//		names[0] = "ȫ�浿";
//		names[1] = "�̼���";
		String[] names = {"ȫ�浿","�̼���","�̼���","��������","������",
				"�����ҹ�","Tom","TOM"};
		System.out.println(Arrays.toString(names));
		
//		2. �迭�� �ִ� ���� ������ �޸�(,)�� �����Ͽ� �� ���ο� ���
//		   ��� ��) ȫ�浿,�̼���,�̼���,��������....
		//names[0] + "," + names[1] + "," + names[2] + "," ... + names[7]
		if (names.length > 0) {
			System.out.print(names[0]);
		}
		for (int i = 1; i < names.length; i++) {
			System.out.print("," + names[i]);
		}
		System.out.println();
		System.out.println("---- �迭�� ù��° ���� Ȯ�� ---");
		//ù ��° �ݺ��� ���� ���θ� �Ǵ��ؼ� ���� ó��
		boolean isFirst = true;
		for (int i = 0; i < names.length; i++) {
			if (isFirst) {
				System.out.print(names[i]);
				isFirst = false;
			} else {
				System.out.print("," + names[i]);
			}
		}
		System.out.println();
		
		System.out.println("---- �迭�� ������ ���� Ȯ�� ---");
		for (int i = 0; i < names.length; i++) {
			if (i == (names.length - 1)) {
				System.out.print(names[i]);
			} else {
				System.out.print(names[i] + ",");
			}
		}
		System.out.println();
		
		System.out.println("===== 3�� ============");
//		3. �迭�� �ִ� ����Ÿ�� ù ���ڸ� ���-������ �޸�(,) ��� �� ���ο� ���
//		   ��� ��) ȫ,��,��,��,��,��,T,T...
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i].charAt(0));
			} else {
				System.out.print("," + names[i].charAt(0));
			}
		}
		System.out.println();
		
		System.out.println("==== 4�� ===========");
//		4. �̸��� ���ڼ��� 4���� �̻��� �̸��� �˻��ؼ� "�ε�����ȣ:�̸�" ���·� ���
//		   ��) 3(�ε�����ȣ):��������
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.println(i + ":" + names[i]);
			}
		}
		System.out.println();
		
		System.out.println("===== 5�� ==========");
//		5. �̸��� ���� �����͸� "�ε�����ȣ:�̸�=�ε�����ȣ:�̸�" ���·� ���
//		   ��) 1:�̼���=2:�̼���
//		(��Ÿ) �̸� �񱳽ÿ��� ��ҹ��� ���� ���� ��ó��(Tom, TOM �� ����)
		//ȫ�浿,�̼���,�̼���,��������,������,�����ҹ�,Tom,TOM
		//�����ε��� : 0
		if (names[0].equalsIgnoreCase(names[1])) {
			System.out.println(0 + ":" + names[0] + "=" + 1 + ":" + names[1]);
		}
		if (names[0].equalsIgnoreCase(names[2])) {
			System.out.println(0 + ":" + names[0] + "=" + 2 + ":" + names[2]);
		}
		if (names[0].equalsIgnoreCase(names[3])) {
			System.out.println(0 + ":" + names[0] + "=" + 3 + ":" + names[3]);
		}
		//....
		if (names[0].equalsIgnoreCase(names[names.length - 1])) {
			System.out.println(0 + ":" + names[0] 
					+ "=" + (names.length - 1) + ":" + names[names.length - 1]);
		}
		
		//�����ε��� : 1 -------------------
		if (names[1].equalsIgnoreCase(names[2])) {
			System.out.println(1 + ":" + names[1] + "=" + 2 + ":" + names[2]);
		}
		if (names[1].equalsIgnoreCase(names[3])) {
			System.out.println(1 + ":" + names[1] + "=" + 3 + ":" + names[3]);
		}
		//...
		if (names[1].equalsIgnoreCase(names[names.length - 1])) {
			System.out.println(1 + ":" + names[1] 
					+ "=" + (names.length - 1) + ":" + names[names.length - 1]);
		}
		System.out.println("===============");
		for (int i = 1; i < names.length; i++) {
			if (names[0].equalsIgnoreCase(names[i])) {
				System.out.println(0 + ":" + names[0] + "=" + i + ":" + names[i]);
			}
		}
		for (int i = 2; i < names.length; i++) {
			if (names[1].equalsIgnoreCase(names[i])) {
				System.out.println(1 + ":" + names[1] + "=" + i + ":" + names[i]);
			}
		}
		//.....
		//�����ε��� : �Ǹ����� ���� ������
		for (int i = names.length - 1; i < names.length; i++) {
			if (names[names.length-2].equalsIgnoreCase(names[i])) {
				System.out.println((names.length-2) + ":" + names[names.length-2] + "=" + i + ":" + names[i]);
			}
		}
		
		System.out.println("==== ���� for������ ====");
		for (int gijun = 0; gijun < names.length-1; gijun++) {
			for (int i = (gijun+1); i < names.length; i++) {
				if (names[gijun].equalsIgnoreCase(names[i])) {
					System.out.println(gijun + ":" + names[gijun] 
							+ "=" + i + ":" + names[i]);
				}
			}
		}
		
		
	}

}













