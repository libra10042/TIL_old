package com.mystudy.split;

import java.util.Arrays;
import java.util.StringTokenizer;

/* ���ڿ� �ٷ��
0.���ڿ� ������
  String str1 = "ȫ�浿 �̼���   �̼��� Tom ȫ�浿";
  String str2 = "    TOM    �������� ������ �����ҹ�";
1. ���� ���ڿ��� StringBuilder ���� sb�� �̿��ؼ� �ϳ��� ���ڿ��� �����,
2-1. sb�� ���ڿ��� ��ĭ(" ")�� �����ڷ� �߶� �̸��� ���� �� ȭ�� ���(����ŸȮ��)
     (String.split() �Ǵ� StringTokenizer Ŭ���� ���)
      ��) ȫ�浿 �̼��� �̼��� Tom ȫ�浿 TOM...
2-2. ���ڿ��� ������ �� �ִ� �迭����(names)�� ����
3. �迭�� �ִ� ���� ������ �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
      ��) ȫ�浿,�̼���,�̼���,Tom,ȫ�浿,TOM...   
4. �������� ù���ڸ� �����ؼ� �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
      ��) ȫ,��,��,T,ȫ,T,��... 
5. �迭�� ���ڿ��� �̸��� ���ڼ��� 4 �̻��� ���� "�ε�����ȣ:�̸�" ���
      ��) �ε�����ȣ:��������
------------------------------------- */
public class Ex02_StringControl_exam {

	public static void main(String[] args) {
		String str1 = "ȫ�浿 �̼���   �̼��� Tom ȫ�浿";
		String str2 = "    TOM    �������� ������ �����ҹ�";
		//1. ���� ���ڿ��� StringBuilder ���� sb�� �̿��ؼ� �ϳ��� ���ڿ��� �����,
		//StringBuilder sb = new StringBuilder(str1 + str2);
//		StringBuilder sb = new StringBuilder();
//		sb.append(str1);
//		sb.append(str2);
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println("sb : " + sb.toString());
		
//		2-1. sb�� ���ڿ��� ��ĭ(" ")�� �����ڷ� �߶� �̸��� ���� �� ȭ�� ���(����ŸȮ��)
//	     (String.split() �Ǵ� StringTokenizer Ŭ���� ���)
//	          ��) ȫ�浿 �̼��� �̼��� Tom ȫ�浿 TOM...
		StringTokenizer stk = new StringTokenizer(sb.toString(), " ");
		System.out.println("��ū���� : " + stk.countTokens());
		while (stk.hasMoreTokens()) {
			System.out.print(stk.nextToken() + " ");
		}
		System.out.println();
		System.out.println("��ū���� : " + stk.countTokens());
		
		//2-2. ���ڿ��� ������ �� �ִ� �迭����(names)�� ����
		stk = new StringTokenizer(sb.toString(), " ");
		String[] names = new String[stk.countTokens()];
		System.out.println("names ũ�� : " + names.length);
		//��ū�� �迭�� ����
		int index = 0;
		while (stk.hasMoreTokens()) {
			names[index] = stk.nextToken();
			index++;
		}
		System.out.println(Arrays.toString(names));
		
//		3. �迭�� �ִ� ���� ������ �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
//	      ��) ȫ�浿,�̼���,�̼���,Tom,ȫ�浿,TOM...
		System.out.println("---- 3�� ----");
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i]);
				sb1.append(names[i]);
			} else {
				System.out.print("," + names[i]);
				//sb1.append("," + names[i]);
				sb1.append(",").append(names[i]);
			}
		}
		System.out.println();
		System.out.println("-----");
		System.out.println("sb1 : " + sb1);
		
		System.out.println("====== 4�� ================");
//		4. �������� ù���ڸ� �����ؼ� �޸�(,)�� �����Ͽ� �Ѷ��ο� ���(StringBuilder ���)
//	      ��) ȫ,��,��,T,ȫ,T,��... 
		sb1.setLength(0); //��ü����Ÿ ���� ó��
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				sb1.append(names[i].charAt(0));
			} else {
				sb1.append(",").append(names[i].charAt(0));
			}
		}
		System.out.println("sb1 : " + sb1);
		System.out.println();
		
		System.out.println("======= 5�� =============");
//		5. �迭�� ���ڿ��� �̸��� ���ڼ��� 4 �̻��� ���� "�ε�����ȣ:�̸�" ���
//	         ��) �ε�����ȣ:��������
		sb1.setLength(0);
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				//System.out.println(i + ":" + names[i]);
				sb1.append(i).append(":").append(names[i]).append("\n");
			}
		}
		System.out.println("sb1: " + sb1);
		
		//============================================
		System.out.println("=========== split() ���� ============");
		System.out.println("sb : " + sb);
		String[] names2 = sb.toString().split(" ");
		for (int i = 0; i < names2.length; i++) {
			System.out.println(i + " : -" + names2[i] + "-");
		}
		System.out.println("---�̸��� ��� ---");
		for (int i = 0; i < names2.length; i++) {
			if (!names2[i].equals("")) { //���� ���ڿ� ���� Ȯ��
				System.out.println(i + " : -" + names2[i] + "-");
			}
		}
		System.out.println("-----");
		for (int i = 0; i < names2.length; i++) {
			if (names2[i].length() > 0) { //ũ���
				System.out.println(i + " : -" + names2[i] + "-");
			}
		}
		
	}//end main

}//end class













