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
		/* (실습) List 사용 실습
		1. List 사용
			- 이름 등록 : 홍길동, 강감찬, 박나래, 이순신
			- 출력예) index : 이름(데이터)
			- 데이터수정 : 홍길동 -> 홍길동2
			- 바뀐 데이터 확인 : 화면출력
		***************************/
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("강감찬");
		list.add("박나래");
		list.add("이순신");
		System.out.println(list);
		
		//- 출력예) index : 이름(데이터)
		System.out.println("--- List for문(전체조회) ---");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
		//- 데이터수정 : 홍길동 -> 홍길동2
		final String ASIS_NAME = "홍길동"; //변경전 : AS-IS, ASIS
		final String TOBE_NAME = "홍길동2"; //변경후 : TO-BE, TOBE
		if (list.contains(ASIS_NAME)) {
			list.set(list.indexOf(ASIS_NAME), TOBE_NAME);
		} else {
			System.out.println(">> " + ASIS_NAME + " 데이터 없습니다.");
		}
		
		System.out.println(list.get(list.indexOf(TOBE_NAME)));
		
		System.out.println("--- List 개선된 for문(전체조회) ---");
		int idx = 0;
		//for (변수선언 : 집합객체) { }
		for (String name : list) {
			System.out.println(idx + " : " + name);
			idx++;
		}
		
		//강감찬 이름을 찾아서 강감찬2로 변경 : 직접 이름 비교
		for (idx = 0; idx < list.size(); idx++) {
			if ("강감찬".equals(list.get(idx))) {
				list.set(idx, "강감찬2");
			}
		}
		System.out.println(list);
		
		
		System.out.println("======= Set ==========");
		// 2. Set 사용
		// - 이름등록 : 홍길동, 강감찬, 박나래, 이순신
		// - 출력 : 이름 (오름차순, 가나다순)
		// - 수정 : 홍길동 -> 홍길동2
		// - 수정 : 강감찬 --> 강감찬2 (이름을 비교확인 해서)
		//--------------------------------
		Set<String> set = new TreeSet<>();
		set.add("홍길동");
		set.add("강감찬");
		set.add("박나래");
		set.add("이순신");
		System.out.println(set);
		
		for (String name : set) {
			System.out.println(name);
		}
		
		// - 수정 : 홍길동 -> 홍길동2
		if (set.contains("홍길동")) {
			set.remove("홍길동");
			set.add("홍길동2");
		} else {
			System.out.println(">> 홍길동 데이터 없습니다.");
		}
		System.out.println("set : " + set);
		
		// - 수정 : 강감찬 --> 강감찬2 (이름을 비교확인 해서)
		// Iterator 사용시 사용하는 데이터를 직접 변경하는 경우 
		//     ConcurrentModificationException 발생할 수 있음
//		Iterator<String> ite = set.iterator();
//		while (ite.hasNext()) {
//			String name = ite.next(); //ConcurrentModificationException
//			if ("강감찬".equals(name)) {
//				set.remove("강감찬"); //ConcurrentModificationException
//				set.add("강감찬2");
//			}
//		}
//		System.out.println("set : " + set);
		
		System.out.println("======= Map ==========");
		// 3. Map 사용
		// - k-v : 101-홍길동, 102-강감찬, 103-박나래, 104-이순신
		// - 출력예) 101-홍길동 (key 오름차순 정렬)
		// - 수정 : 홍길동 --> 홍길동2 (key 값 사용 : 101)
		// - 수정 : 강감찬 --> 강감찬2 (이름을 비교확인 해서)
		//------------------------------------------
		Map<Integer, String> map = new TreeMap<>();
		map.put(102, "강감찬");
		map.put(104, "이순신");
		map.put(103, "박나래");
		map.put(101, "홍길동");
		System.out.println(map);
		
		for (Integer id : map.keySet()) {
			System.out.println(id + " - " + map.get(id));
		}
		
		// - 수정 : 홍길동 --> 홍길동2 (key 값 사용 : 101)
		map.replace(101, "홍길동2");
		System.out.println(map);
		
		// - 수정 : 강감찬 --> 강감찬2 (이름을 비교확인 해서)
		for (Integer id : map.keySet()) {
			if ("강감찬".equals(map.get(id))) {
				map.replace(id, "강감찬2");
			}
		}
		System.out.println(map);
	}

}








