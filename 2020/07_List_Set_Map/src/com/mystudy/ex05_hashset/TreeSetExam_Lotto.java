package com.mystudy.ex05_hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExam_Lotto {

	public static void main(String[] args) {
		//TreeSet : �����͸� ������ �� �����ؼ� ����
		
		/* (�ǽ�) Set�� �̿��� �ζǸ����(TreeSet)
		�ζǹ�ȣ : 1 ~ 45 �������� 6���� Set�� ����
		�ζǹ�ȣ 6���� ��÷, ���� ���ں��� ������� ȭ�� ���
		- Math.random() ����ؼ� ������ ���� �����
		  (int)(Math.random() * 45 + 1)
		- ����� ���� ���ں��� ū���� ���·�
		    ��¿�) ������ �ζǹ�ȣ : 5, 8, 10, 25, 33, 41
		******************************** */
		Set<Integer> lottoSet = new TreeSet<>();
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
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
		while (lottoSet.size() < 6) { //set ������ 6������
			lottoSet.add((int)(Math.random() * 45 + 1));
		}
		System.out.println("�ζǹ�ȣ : " + lottoSet);
		System.out.println("�ζǹ�ȣ ���� : " + lottoSet.size());
		
	}

}










