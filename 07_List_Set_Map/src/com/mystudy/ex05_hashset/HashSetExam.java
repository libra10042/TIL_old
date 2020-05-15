package com.mystudy.ex05_hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		// Set 인터페이스 : Set 타입에서 구현되어야 할 메소드 정의(추상체)
		// HashSet : Set 인터페이스를 구현한 클래스(구현체)
		//--------------------------------------
		//HashSet<String> set = new HashSet<>();
		
		//인터페이스  변수 <---- 인터페이스를 구현한 클래스 객체(인스턴스)
		Set<String> set = new HashSet<>();
		
		set.add("1");
		//set.add(100); //제너릭 타입 설정에 따라 문자열(String)만 사용가능
		set.add("홍길동");
		set.add("홍길동");
		set.add(new String("홍길동"));
		System.out.println("set : " + set);
		
		set.remove("1");
		System.out.println("set : " + set);
		
		System.out.println("set.contains(\"홍길동\") : " 
				+ set.contains("홍길동"));
		System.out.println("set.size() : " + set.size());
		
		set.add("김유신");
		set.add("을지문덕");
		set.add("홍경래");
		System.out.println("set : " + set);
		
		System.out.println("------ Set 전체 데이터 조회(Iterator) -----");
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.println("------------");
		
		//---------------------------
		//실습(수정) : 김유신 -> 김유신2 (변경처리)
		//김유신 삭제하고 김유신2 입력(방법1)
		//김유신2 입력하고 김유신 삭제(방법2)
		System.out.println("--- 김유신 ==> 김유신2(수정) ---");
		if (set.contains("김유신")) {//데이터가 있으면
			set.remove("김유신");
			set.add("김유신2");
		} else {
			System.out.println(">> 데이터 없음");
		}
		System.out.println("set : " + set);
	}

}











