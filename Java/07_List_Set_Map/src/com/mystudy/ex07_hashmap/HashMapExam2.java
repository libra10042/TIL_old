package com.mystudy.ex07_hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExam2 {

	public static void main(String[] args) {
		// 개선된 for문을 사용한 Map 데이터 조회
		int[] nums = {10, 20, 30, 40};
		System.out.println("-- 기본형태 for문 배열값 출력 --");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		System.out.println("--- 개선된 for문 배열값 출력 ---");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		System.out.println("===================");
		Map<String, String> map = new HashMap<>();
		map.put("키1", "값1");
		map.put("키2", "값2");
		map.put("키3", "값3");
		map.put("키4", "값4");
		System.out.println(map);
		
		//=======================
		//전체 데이터 화면 출력
		//출력예) 키1-값1
		//(실습1) : keySet(), iterator() 사용(while문 사용방식)
		System.out.println("---- Map 데이터 조회 : while문 ---");
		Set<String> set = map.keySet();
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			System.out.println(key + "-" + map.get(key));
		}
		
		System.out.println("---- Map 데이터 조회 : 개선된 for문 ---");
		//(실습2) : keySet() 사용(개선된 for문 사용)
		Set<String> keys = map.keySet();
		for (String key : keys ) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		System.out.println("------");
		for (String key : map.keySet() ) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		
		System.out.println("======= entrySet() 개선된 for문 ======");
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		
		System.out.println("---------");
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println("key: " + entry.getKey() 
					+ ", value: " + entry.getValue());
		}
	}

}











