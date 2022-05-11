package com.mystudy.ex05_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetExam_Lotto {

	public static void main(String[] args) {
		/* (�ǽ�) Set�� �̿��� �ζǸ����
		�ζǹ�ȣ : 1 ~ 45 �������� 6���� Set�� ����
		�ζǹ�ȣ 6���� ��÷, ���� ���ں��� ������� ȭ�� ���
		- Math.random() ����ؼ� ������ ���� �����
		  (int)(Math.random() * 45 + 1)
		- ����� ���� ���ں��� ū���� ���·�
		    ��¿�) ������ �ζǹ�ȣ : 5, 8, 10, 25, 33, 41
		******************************** */
		Set<Integer> lottoSet = new HashSet<>();
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		System.out.println(lottoSet); //�ߺ����� ������ 6�� ���� ���� ����
//		System.out.println(lottoSet.size());
		
		//Set�� �����Ͱ� 6�� �� ������ �ζǹ�ȣ �����
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
		//for (int i = 0; i < 6; i++) { //6���� ��÷
		for (int i = 0; lottoSet.size() < 6; i++) { //set ������ 6������
			int lottoNum = (int)(Math.random() * 45 + 1);
			System.out.println("��÷��ȣ : " + lottoNum);
			lottoSet.add(lottoNum);
		}
		System.out.println("�ζǹ�ȣ : " + lottoSet);
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
		
		System.out.println("--------------------------");
		lottoSet.clear();
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
		for (; lottoSet.size() < 6; ) { //set ������ 6������
			int lottoNum = (int)(Math.random() * 45 + 1);
			System.out.println("��÷��ȣ : " + lottoNum);
			lottoSet.add(lottoNum);
		}
		System.out.println("�ζǹ�ȣ : " + lottoSet);
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
		
		System.out.println("--------------------------");
		lottoSet.clear();
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
		while (lottoSet.size() < 6) { //set ������ 6������
			lottoSet.add((int)(Math.random() * 45 + 1));
		}
		System.out.println("�ζǹ�ȣ : " + lottoSet);
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
		
		System.out.println("==== �ζǹ�ȣ ���� =====");
		ArrayList<Integer> list = new ArrayList<>(lottoSet);
		
		Collections.sort(list);
		System.out.println("������ �ζǹ�ȣ : " + list);
	}

}













