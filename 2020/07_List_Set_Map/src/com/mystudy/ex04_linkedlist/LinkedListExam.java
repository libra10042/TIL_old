package com.mystudy.ex04_linkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListExam {

	public static void main(String[] args) {
		// LinkedList Ŭ���� : List �������̽� �迭
		LinkedList<String> list = new LinkedList<>();
		list.add("ȫ�浿");
//		list.add("ȫ�浿");
//		list.add("������");
		System.out.println("list : " + list);
		System.out.println(list.get(0));
		System.out.println("----------------");
		
		String str = "����,������,������,ȫ�淡,��������";
		String[] strs = str.split(",");
		System.out.println("strs : " + Arrays.toString(strs));
		
		//�迭�� �ִ� �����͸� ����Ʈ�� �߰�
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		System.out.println("list : " + list);
		
		System.out.println("----------------");
		Collections.reverse(list);
		System.out.println("list : " + list);
		
		Collections.sort(list);
		System.out.println("list : " + list);
		
		//���� : ������
		list.remove("������");
		System.out.println("������ ���� �� list : " + list);
		
		//------------------------------
		//(�ǽ�) �������� -> ��������2 ����ó��(����)
		//1. "��������" �� ��� �ִ��� ã��(indexOf)
		//2. ã�� ��ġ�� "��������2" �� ����(set �޼ҵ�)
		int index2 = -1;
		for (int i = 0; i < list.size(); i++) {
			if ("��������".equals(list.get(i))) {
				index2 = i;
				break;
			}
		}
		System.out.println("index2 : " + index2);
		
		System.out.println("------");
		//1. "��������" �� ��� �ִ��� ã��(indexOf)
		int index = list.indexOf("��������");
		System.out.println("index : " + index);
		
		//2. ã�� ��ġ�� "��������2" �� ����(set �޼ҵ�)
		list.set(index, "��������2");
		System.out.println("������ list : " + list);
		
		System.out.println("------");
		list.set(list.indexOf("��������2"), "��������3");
		System.out.println("������ list : " + list);
		
	}

}










