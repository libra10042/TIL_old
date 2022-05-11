package com.mystudy.ex05_hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		// Set �������̽� : Set Ÿ�Կ��� �����Ǿ�� �� �޼ҵ� ����(�߻�ü)
		// HashSet : Set �������̽��� ������ Ŭ����(����ü)
		//--------------------------------------
		//HashSet<String> set = new HashSet<>();
		
		//�������̽�  ���� <---- �������̽��� ������ Ŭ���� ��ü(�ν��Ͻ�)
		Set<String> set = new HashSet<>();
		
		set.add("1");
		//set.add(100); //���ʸ� Ÿ�� ������ ���� ���ڿ�(String)�� ��밡��
		set.add("ȫ�浿");
		set.add("ȫ�浿");
		set.add(new String("ȫ�浿"));
		System.out.println("set : " + set);
		
		set.remove("1");
		System.out.println("set : " + set);
		
		System.out.println("set.contains(\"ȫ�浿\") : " 
				+ set.contains("ȫ�浿"));
		System.out.println("set.size() : " + set.size());
		
		set.add("������");
		set.add("��������");
		set.add("ȫ�淡");
		System.out.println("set : " + set);
		
		System.out.println("------ Set ��ü ������ ��ȸ(Iterator) -----");
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.println("------------");
		
		//---------------------------
		//�ǽ�(����) : ������ -> ������2 (����ó��)
		//������ �����ϰ� ������2 �Է�(���1)
		//������2 �Է��ϰ� ������ ����(���2)
		System.out.println("--- ������ ==> ������2(����) ---");
		if (set.contains("������")) {//�����Ͱ� ������
			set.remove("������");
			set.add("������2");
		} else {
			System.out.println(">> ������ ����");
		}
		System.out.println("set : " + set);
	}

}











