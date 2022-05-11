package com.mystudy.ex09_list_set_map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class List_Set_Map {

	public static void main(String[] args) {
		System.out.println("======= List ==========");
		/* (�ǽ�) List ��� �ǽ�
		1. List ���
			- �̸� ��� : ȫ�浿, ������, �ڳ���, �̼���
			- ��¿�) index : �̸�(������)
			- �����ͼ��� : ȫ�浿 -> ȫ�浿2
			- �ٲ� ������ Ȯ�� : ȭ�����
		***************************/
		List<String> list = new ArrayList<String>();
		list.add("ȫ�浿");
		list.add("������");
		list.add("�ڳ���");
		list.add("�̼���");
		System.out.println(list);
		
		//- ��¿�) index : �̸�(������)
		System.out.println("--- List for��(��ü��ȸ) ---");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
		//- �����ͼ��� : ȫ�浿 -> ȫ�浿2
		final String ASIS_NAME = "ȫ�浿"; //������ : AS-IS, ASIS
		final String TOBE_NAME = "ȫ�浿2"; //������ : TO-BE, TOBE
		if (list.contains(ASIS_NAME)) {
			list.set(list.indexOf(ASIS_NAME), TOBE_NAME);
		} else {
			System.out.println(">> " + ASIS_NAME + " ������ �����ϴ�.");
		}
		
		System.out.println(list.get(list.indexOf(TOBE_NAME)));
		
		System.out.println("--- List ������ for��(��ü��ȸ) ---");
		int idx = 0;
		//for (�������� : ���հ�ü) { }
		for (String name : list) {
			System.out.println(idx + " : " + name);
			idx++;
		}
		
		//������ �̸��� ã�Ƽ� ������2�� ���� : ���� �̸� ��
		for (idx = 0; idx < list.size(); idx++) {
			if ("������".equals(list.get(idx))) {
				list.set(idx, "������2");
			}
		}
		System.out.println(list);
		
		
		System.out.println("======= Set ==========");
		// 2. Set ���
		// - �̸���� : ȫ�浿, ������, �ڳ���, �̼���
		// - ��� : �̸� (��������, �����ټ�)
		// - ���� : ȫ�浿 -> ȫ�浿2
		// - ���� : ������ --> ������2 (�̸��� ��Ȯ�� �ؼ�)
		//--------------------------------
		Set<String> set = new TreeSet<>();
		set.add("ȫ�浿");
		set.add("������");
		set.add("�ڳ���");
		set.add("�̼���");
		System.out.println(set);
		
		for (String name : set) {
			System.out.println(name);
		}
		
		// - ���� : ȫ�浿 -> ȫ�浿2
		if (set.contains("ȫ�浿")) {
			set.remove("ȫ�浿");
			set.add("ȫ�浿2");
		} else {
			System.out.println(">> ȫ�浿 ������ �����ϴ�.");
		}
		System.out.println("set : " + set);
		
		// - ���� : ������ --> ������2 (�̸��� ��Ȯ�� �ؼ�)
		// Iterator ���� ����ϴ� �����͸� ���� �����ϴ� ��� 
		//     ConcurrentModificationException �߻��� �� ����
//		Iterator<String> ite = set.iterator();
//		while (ite.hasNext()) {
//			String name = ite.next(); //ConcurrentModificationException
//			if ("������".equals(name)) {
//				set.remove("������"); //ConcurrentModificationException
//				set.add("������2");
//			}
//		}
//		System.out.println("set : " + set);
		
		System.out.println("======= Map ==========");
		// 3. Map ���
		// - k-v : 101-ȫ�浿, 102-������, 103-�ڳ���, 104-�̼���
		// - ��¿�) 101-ȫ�浿 (key �������� ����)
		// - ���� : ȫ�浿 --> ȫ�浿2 (key �� ��� : 101)
		// - ���� : ������ --> ������2 (�̸��� ��Ȯ�� �ؼ�)
		//------------------------------------------
		Map<Integer, String> map = new TreeMap<>();
		map.put(102, "������");
		map.put(104, "�̼���");
		map.put(103, "�ڳ���");
		map.put(101, "ȫ�浿");
		System.out.println(map);
		
		for (Integer id : map.keySet()) {
			System.out.println(id + " - " + map.get(id));
		}
		
		// - ���� : ȫ�浿 --> ȫ�浿2 (key �� ��� : 101)
		map.replace(101, "ȫ�浿2");
		System.out.println(map);
		
		// - ���� : ������ --> ������2 (�̸��� ��Ȯ�� �ؼ�)
		for (Integer id : map.keySet()) {
			if ("������".equals(map.get(id))) {
				map.replace(id, "������2");
			}
		}
		System.out.println(map);
	}

}








