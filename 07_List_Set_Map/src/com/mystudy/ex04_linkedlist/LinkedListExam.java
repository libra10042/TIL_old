package com.mystudy.ex04_linkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListExam {

	public static void main(String[] args) {
		// LinkedList 클래스 : List 인터페이스 계열
		LinkedList<String> list = new LinkedList<>();
		list.add("홍길동");
//		list.add("홍길동");
//		list.add("김유신");
		System.out.println("list : " + list);
		System.out.println(list.get(0));
		System.out.println("----------------");
		
		String str = "강강,김유신,강감찬,홍경래,을지문덕";
		String[] strs = str.split(",");
		System.out.println("strs : " + Arrays.toString(strs));
		
		//배열에 있는 데이터를 리스트에 추가
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		System.out.println("list : " + list);
		
		System.out.println("----------------");
		Collections.reverse(list);
		System.out.println("list : " + list);
		
		Collections.sort(list);
		System.out.println("list : " + list);
		
		//삭제 : 김유신
		list.remove("김유신");
		System.out.println("김유신 삭제 후 list : " + list);
		
		//------------------------------
		//(실습) 을지문덕 -> 을지문덕2 변경처리(수정)
		//1. "을지문덕" 이 어디에 있는지 찾고(indexOf)
		//2. 찾은 위치에 "을지문덕2" 로 수정(set 메소드)
		int index2 = -1;
		for (int i = 0; i < list.size(); i++) {
			if ("을지문덕".equals(list.get(i))) {
				index2 = i;
				break;
			}
		}
		System.out.println("index2 : " + index2);
		
		System.out.println("------");
		//1. "을지문덕" 이 어디에 있는지 찾고(indexOf)
		int index = list.indexOf("을지문덕");
		System.out.println("index : " + index);
		
		//2. 찾은 위치에 "을지문덕2" 로 수정(set 메소드)
		list.set(index, "을지문덕2");
		System.out.println("수정후 list : " + list);
		
		System.out.println("------");
		list.set(list.indexOf("을지문덕2"), "을지문덕3");
		System.out.println("수정후 list : " + list);
		
	}

}










