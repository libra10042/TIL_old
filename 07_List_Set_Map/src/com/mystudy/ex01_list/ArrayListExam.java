package com.mystudy.ex01_list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExam {

	public static void main(String[] args) {
		// List 계열 : ArrayList - 배열의 속성과 List 속성을 가짐
		//   - List는 Collection 인터페이스를 상속확장(extends)해서 만든 인터페이스
		//   - ArrayList는 List 인터페이스를 상속 구현(implements)한 클래스
		ArrayList list1 = new ArrayList();
		System.out.println("list1.size() : " + list1.size());
		
		//데이터 입력(맨 뒤에 추가)
		list1.add(new Integer(5)); //인덱스 0 위치
		list1.add(1); //인덱스 1 위치 : int -> Integer 자동형변환 되어 입력됨
		list1.add(new Integer(5)); //인덱스 2 위치
		list1.add(new Integer(6));
		list1.add(new Integer(7));
		System.out.println(list1.toString());
		System.out.println("list1.size() : " + list1.size());

		//데이터 조회(검색) - 인덱스 번호로
		Object obj = list1.get(0);
		System.out.println("0 인덱스 값 : " + obj.toString());
		
		//데이터 추가(삽입 - insert)
		list1.add(0, 100); //인덱스 위치에 데이터 추가(삽입)
		System.out.println("0 인덱스 100 add후 : " + list1);
		
		list1.set(0, 999); //인덱스 위치에 데이터 수정(변경)
		System.out.println("0 인덱스 999 set후 : " + list1);
		
		list1.remove(0); //인덱스 위치의 데이터 삭제
		System.out.println("0 인덱스 remove후 : " + list1);
		
		//list1.remove(5); //숫자 5를 삭제하는 것이 아닌 5번 인덱스 값 삭제로 동작
		list1.remove(new Integer(5));
		System.out.println("숫자 Integer 5 삭제 후 : " + list1);
		
		System.out.println("---- Collections.reverse() ------");
		Collections.reverse(list1);
		System.out.println("reverse 적용후: " + list1);
//		Collections.reverse(list1);
//		System.out.println("reverse 적용후: " + list1);
		
		System.out.println("-------------------");
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		System.out.println("list2 : " + list2);
		
		System.out.println("--- Collections.sort() ---");
		System.out.println("정렬전 : " + list2);
		Collections.sort(list2); //오름차순 정렬
		System.out.println("정렬후 : " + list2);
		
		System.out.println("---- Collections.reverse() ------");
		//내림차순 정렬 기능은 없으나 오름차순 정렬 후 reverse() 실행
		Collections.reverse(list2); //오름차순 정렬
		System.out.println("정렬후 reverse 후 : " + list2);
		
		System.out.println("=========================");
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		
		list2.add("B");
		list2.add("TEST");
		System.out.println("list2 : " + list2);
		System.out.println("indexOf(\"TEST\") : " + list2.indexOf("TEST"));
		
		System.out.println("첫번째 데이터 조회 : " + list2.get(0));
		System.out.println("마지막 데이터 조회 : " 
				+ list2.get(list2.size() - 1));
		
		System.out.println("----------------");
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " - " + list2.get(i));
		}
		
		//=============================================
		System.out.println("==========================");
		//실습 : 반복문(for)을 사용해서 list2에 있는 전체 데이터 삭제
		//list2.clear();
		System.out.println("list2.size() : " + list2.size());

		//(문제발생) list2.size() 메소드의 값이 줄어드는 현상으로 남는데이터 발생
//		for (int i = 0; i < list2.size(); i++) {
//			list2.remove(i);
//			System.out.println(">> list2.size() : " + list2.size());
//		}
//		System.out.println("list2 : " + list2);
		
		//(문제발생) 삭제하려는 위치에 데이터가 없는 경우 발생
//		int listSize = list2.size();
//		for (int i = 0; i < listSize; i++) {
//			list2.remove(i);
//			System.out.println(">> list2.size() : " + list2.size());
//		}
//		System.out.println("list2 : " + list2);
		
		System.out.println("----------");
		//(해결1)데이터 갯수만큼 0번 인덱스 값 삭제
//		System.out.println("list2 : " + list2);
//		System.out.println("list2.size() : " + list2.size());
//		int listSize = list2.size();
//		for (int i = 0; i < listSize; i++) {
//			list2.remove(0);
//		}
//		System.out.println("list2 : " + list2);
		
		System.out.println("-------------");
		//(해결2) 마지막 데이터부터 앞쪽으로 삭제 처리
		System.out.println("list2 : " + list2);
		System.out.println("list2.size() : " + list2.size());
		int lastIndex = list2.size() - 1;
		for (int i = lastIndex; i >= 0; i--) {
			list2.remove(i);
			System.out.println("list2 : " + list2);
		}
		System.out.println("list2 : " + list2);
	}

}












