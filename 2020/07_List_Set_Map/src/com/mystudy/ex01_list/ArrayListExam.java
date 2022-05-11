package com.mystudy.ex01_list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExam {

	public static void main(String[] args) {
		// List �迭 : ArrayList - �迭�� �Ӽ��� List �Ӽ��� ����
		//   - List�� Collection �������̽��� ���Ȯ��(extends)�ؼ� ���� �������̽�
		//   - ArrayList�� List �������̽��� ��� ����(implements)�� Ŭ����
		ArrayList list1 = new ArrayList();
		System.out.println("list1.size() : " + list1.size());
		
		//������ �Է�(�� �ڿ� �߰�)
		list1.add(new Integer(5)); //�ε��� 0 ��ġ
		list1.add(1); //�ε��� 1 ��ġ : int -> Integer �ڵ�����ȯ �Ǿ� �Էµ�
		list1.add(new Integer(5)); //�ε��� 2 ��ġ
		list1.add(new Integer(6));
		list1.add(new Integer(7));
		System.out.println(list1.toString());
		System.out.println("list1.size() : " + list1.size());

		//������ ��ȸ(�˻�) - �ε��� ��ȣ��
		Object obj = list1.get(0);
		System.out.println("0 �ε��� �� : " + obj.toString());
		
		//������ �߰�(���� - insert)
		list1.add(0, 100); //�ε��� ��ġ�� ������ �߰�(����)
		System.out.println("0 �ε��� 100 add�� : " + list1);
		
		list1.set(0, 999); //�ε��� ��ġ�� ������ ����(����)
		System.out.println("0 �ε��� 999 set�� : " + list1);
		
		list1.remove(0); //�ε��� ��ġ�� ������ ����
		System.out.println("0 �ε��� remove�� : " + list1);
		
		//list1.remove(5); //���� 5�� �����ϴ� ���� �ƴ� 5�� �ε��� �� ������ ����
		list1.remove(new Integer(5));
		System.out.println("���� Integer 5 ���� �� : " + list1);
		
		System.out.println("---- Collections.reverse() ------");
		Collections.reverse(list1);
		System.out.println("reverse ������: " + list1);
//		Collections.reverse(list1);
//		System.out.println("reverse ������: " + list1);
		
		System.out.println("-------------------");
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		System.out.println("list2 : " + list2);
		
		System.out.println("--- Collections.sort() ---");
		System.out.println("������ : " + list2);
		Collections.sort(list2); //�������� ����
		System.out.println("������ : " + list2);
		
		System.out.println("---- Collections.reverse() ------");
		//�������� ���� ����� ������ �������� ���� �� reverse() ����
		Collections.reverse(list2); //�������� ����
		System.out.println("������ reverse �� : " + list2);
		
		System.out.println("=========================");
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		
		list2.add("B");
		list2.add("TEST");
		System.out.println("list2 : " + list2);
		System.out.println("indexOf(\"TEST\") : " + list2.indexOf("TEST"));
		
		System.out.println("ù��° ������ ��ȸ : " + list2.get(0));
		System.out.println("������ ������ ��ȸ : " 
				+ list2.get(list2.size() - 1));
		
		System.out.println("----------------");
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " - " + list2.get(i));
		}
		
		//=============================================
		System.out.println("==========================");
		//�ǽ� : �ݺ���(for)�� ����ؼ� list2�� �ִ� ��ü ������ ����
		//list2.clear();
		System.out.println("list2.size() : " + list2.size());

		//(�����߻�) list2.size() �޼ҵ��� ���� �پ��� �������� ���µ����� �߻�
//		for (int i = 0; i < list2.size(); i++) {
//			list2.remove(i);
//			System.out.println(">> list2.size() : " + list2.size());
//		}
//		System.out.println("list2 : " + list2);
		
		//(�����߻�) �����Ϸ��� ��ġ�� �����Ͱ� ���� ��� �߻�
//		int listSize = list2.size();
//		for (int i = 0; i < listSize; i++) {
//			list2.remove(i);
//			System.out.println(">> list2.size() : " + list2.size());
//		}
//		System.out.println("list2 : " + list2);
		
		System.out.println("----------");
		//(�ذ�1)������ ������ŭ 0�� �ε��� �� ����
//		System.out.println("list2 : " + list2);
//		System.out.println("list2.size() : " + list2.size());
//		int listSize = list2.size();
//		for (int i = 0; i < listSize; i++) {
//			list2.remove(0);
//		}
//		System.out.println("list2 : " + list2);
		
		System.out.println("-------------");
		//(�ذ�2) ������ �����ͺ��� �������� ���� ó��
		System.out.println("list2 : " + list2);
		System.out.println("list2.size() : " + list2.size());
		int lastIndex = list2.size() - 1;
		for (int i = lastIndex; i >= 0; i--) {
			list2.remove(i);
			System.out.println("list2 : " + list2);
		}
		System.out.println("list2 : " + list2);
	}

}












