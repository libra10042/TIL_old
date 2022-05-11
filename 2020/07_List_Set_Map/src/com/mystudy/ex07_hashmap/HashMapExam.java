package com.mystudy.ex07_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExam {

	public static void main(String[] args) {
		// Map(�������̽�) : Ű(key)-��(value) ������ ������ ����
		// - ������ ����(��, TreeMap�� ��� key ���� �������� ����)
		// - Ű(key) : �ߺ� �ȵ�(�ߺ��� ���� ������ ������)
		// - ��(value) : �ߺ� ����
		//------------------------------
		HashMap<String, Integer> map = new HashMap<>();
		map.put("ȫ�浿", 100); //100 -> Integer Ÿ�� 100
		map.put("������", new Integer(95));
		map.put("������", 88);
		map.put("���", 88);
		map.put("ȫ�浿", 93); //������ key ���� �����ϸ� ����ó����
		System.out.println(map);
		
		HashMap<String, Integer> map2 = new HashMap<>();
		map2.put("������", 92);
		map2.put("����ġ", 82);
		System.out.println(map2);
		map2.remove("������");
		System.out.println(map2);
		
		System.out.println("map.isEmpty() : " + map.isEmpty());
		System.out.println("map.get(\"ȫ�浿\") : " + map.get("ȫ�浿"));
		System.out.println("map.containsKey(\"��������\") : " 
				+ map.containsKey("��������"));
		System.out.println("map.containsValue(88) : " 
				+ map.containsValue(88));
		
		//������ ����
		System.out.println("map.replace(\"ȫ�浿\", 99) : " 
				+ map.replace("ȫ�浿", 99));
		System.out.println("map.replace(\"��������\", 99) : " 
				+ map.replace("��������", 99));
		
		//================================
		System.out.println("==== Map ��ü ������ ��ȸ ===");
		//Map������ Ű(key)�� �̿��ؼ� ������(value) ��ȸ
		System.out.println("--- Ű(key) ���� : keySet() ��� -----");
		Set<String> keySet = map.keySet();
		System.out.println("keySet : " + keySet);
		
		Iterator<String> ite = keySet.iterator();
		while (ite.hasNext()) {
			String key = ite.next(); //key ����
			Integer value = map.get(key); //value ����
			System.out.println("key: " + key + ", value: " + value);
		}
		
		System.out.println("--- ��(value) ���� : values() ��� ----");
		Collection<Integer> values = map.values();
		System.out.println("��(values) : " + values);
		
		Iterator<Integer> iteValues = values.iterator();
		//��(value) ���� �հ� ���ϱ�
		int sum = 0;
		while (iteValues.hasNext()) {
			Integer value = iteValues.next();
			System.out.println("���� : " + value);
			sum += value;
		}
		System.out.println("�����հ� : " + sum);
		
		System.out.println("=============================");
		//��ȸ���1 : keySet(), iterator() ���
		System.out.println("---- keySet(), iterator() ��� ---");
		Set<String> set = map.keySet();
		ite = set.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			Integer value = map.get(key);
			System.out.println("key: "+ key + ", value: " + value);
		}
		
		//��ȸ���2 : entrySet() ���
		System.out.println("\n--- entrySet() ��� : key, value ���� ---");
		//Entry : Map ���ο� ����� Entry �������̽� - Map.Entry
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println("entrySet : " + entrySet);
		
		Iterator<Entry<String, Integer>> entryIte = entrySet.iterator();
		while (entryIte.hasNext()) {
			Entry<String, Integer> entry = entryIte.next();
			System.out.println("key: " + entry.getKey()
					+ ", value : " + entry.getValue());
		}
	}

}










