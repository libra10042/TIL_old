package com.mystudy.ex08_treemap;

import java.util.TreeMap;

public class TreeMapExam {

	public static void main(String[] args) {
		// TreeMap : 키(key) 값 기준으로 오름차순 정렬해서 저장
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("홍길동", 100);
		map.put("김유신", new Integer(95));
		map.put("강감찬", 88);
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
		System.out.println("map.get(\"홍길동\") : " 
				+ map.get("홍길동"));
		System.out.println("map.get(\"을지문덕\") : " 
				+ map.get("을지문덕"));
		System.out.println("map.containsValue(88) : " 
				+ map.containsValue(88));
		
		System.out.println("==================");
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}








