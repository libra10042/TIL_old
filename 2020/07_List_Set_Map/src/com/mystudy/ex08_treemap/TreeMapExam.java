package com.mystudy.ex08_treemap;

import java.util.TreeMap;

public class TreeMapExam {

	public static void main(String[] args) {
		// TreeMap : Ű(key) �� �������� �������� �����ؼ� ����
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("ȫ�浿", 100);
		map.put("������", new Integer(95));
		map.put("������", 88);
		map.put("100", 93);
		map.put("20", 93);
		map.put("10", 93);
		map.put("a", 83);
		map.put("A", 83);
		map.put("*", 83);
		map.put("%", 83);
		map.put("_", 83);
		map.put("-", 83);
		
		System.out.println(map);
		System.out.println("=============");
		System.out.println("map.isEmpty() : " + map.isEmpty());
		System.out.println("map.get(\"ȫ�浿\") : " 
				+ map.get("ȫ�浿"));
		System.out.println("map.get(\"��������\") : " 
				+ map.get("��������"));
		System.out.println("map.containsValue(88) : " 
				+ map.containsValue(88));
		
		System.out.println("==================");
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}








