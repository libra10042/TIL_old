package com.mystudy.ex07_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExam {

	public static void main(String[] args) {
		// Map(인터페이스) : 키(key)-값(value) 쌍으로 데이터 관리
		// - 순서가 없다(단, TreeMap의 경우 key 기준 오름차순 정렬)
		// - 키(key) : 중복 안됨(중복값 없이 유일한 데이터)
		// - 값(value) : 중복 가능
		//------------------------------
		HashMap<String, Integer> map = new HashMap<>();
		map.put("홍길동", 100); //100 -> Integer 타입 100
		map.put("김유신", new Integer(95));
		map.put("강감찬", 88);
		map.put("계백", 88);
		map.put("홍길동", 93); //동일한 key 값이 존재하면 수정처리됨
		System.out.println(map);
		
		HashMap<String, Integer> map2 = new HashMap<>();
		map2.put("일지매", 92);
		map2.put("전우치", 82);
		System.out.println(map2);
		map2.remove("일지매");
		System.out.println(map2);
		
		System.out.println("map.isEmpty() : " + map.isEmpty());
		System.out.println("map.get(\"홍길동\") : " + map.get("홍길동"));
		System.out.println("map.containsKey(\"을지문덕\") : " 
				+ map.containsKey("을지문덕"));
		System.out.println("map.containsValue(88) : " 
				+ map.containsValue(88));
		
		//데이터 수정
		System.out.println("map.replace(\"홍길동\", 99) : " 
				+ map.replace("홍길동", 99));
		System.out.println("map.replace(\"을지문덕\", 99) : " 
				+ map.replace("을지문덕", 99));
		
		//================================
		System.out.println("==== Map 전체 데이터 조회 ===");
		//Map에서는 키(key)를 이용해서 데이터(value) 조회
		System.out.println("--- 키(key) 추출 : keySet() 사용 -----");
		Set<String> keySet = map.keySet();
		System.out.println("keySet : " + keySet);
		
		Iterator<String> ite = keySet.iterator();
		while (ite.hasNext()) {
			String key = ite.next(); //key 추출
			Integer value = map.get(key); //value 추출
			System.out.println("key: " + key + ", value: " + value);
		}
		
		System.out.println("--- 값(value) 추출 : values() 사용 ----");
		Collection<Integer> values = map.values();
		System.out.println("값(values) : " + values);
		
		Iterator<Integer> iteValues = values.iterator();
		//값(value) 들의 합계 구하기
		int sum = 0;
		while (iteValues.hasNext()) {
			Integer value = iteValues.next();
			System.out.println("점수 : " + value);
			sum += value;
		}
		System.out.println("점수합계 : " + sum);
		
		System.out.println("=============================");
		//조회방법1 : keySet(), iterator() 사용
		System.out.println("---- keySet(), iterator() 사용 ---");
		Set<String> set = map.keySet();
		ite = set.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			Integer value = map.get(key);
			System.out.println("key: "+ key + ", value: " + value);
		}
		
		//조회방법2 : entrySet() 사용
		System.out.println("\n--- entrySet() 사용 : key, value 추출 ---");
		//Entry : Map 내부에 선언된 Entry 인터페이스 - Map.Entry
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










