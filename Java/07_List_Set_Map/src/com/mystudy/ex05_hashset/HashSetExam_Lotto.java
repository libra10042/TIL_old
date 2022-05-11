package com.mystudy.ex05_hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetExam_Lotto {

	public static void main(String[] args) {
		/* (실습) Set을 이용한 로또만들기
		로또번호 : 1 ~ 45 랜덤숫자 6개를 Set에 저장
		로또번호 6개를 추첨, 작은 숫자부터 순서대로 화면 출력
		- Math.random() 사용해서 랜덤한 숫자 만들기
		  (int)(Math.random() * 45 + 1)
		- 출력은 작은 숫자부터 큰숫자 형태로
		    출력예) 금주의 로또번호 : 5, 8, 10, 25, 33, 41
		******************************** */
		Set<Integer> lottoSet = new HashSet<>();
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		lottoSet.add((int)(Math.random() * 45 + 1));
//		System.out.println(lottoSet); //중복값이 있으면 6개 보다 갯수 작음
//		System.out.println(lottoSet.size());
		
		//Set에 데이터가 6개 될 때까지 로또번호 만들기
		System.out.println("로또번호 갯수 : " + lottoSet.size());
		//for (int i = 0; i < 6; i++) { //6번만 추첨
		for (int i = 0; lottoSet.size() < 6; i++) { //set 데이터 6개까지
			int lottoNum = (int)(Math.random() * 45 + 1);
			System.out.println("추첨번호 : " + lottoNum);
			lottoSet.add(lottoNum);
		}
		System.out.println("로또번호 : " + lottoSet);
		System.out.println("로또번호 갯수 : " + lottoSet.size());
		
		System.out.println("--------------------------");
		lottoSet.clear();
		System.out.println("로또번호 갯수 : " + lottoSet.size());
		for (; lottoSet.size() < 6; ) { //set 데이터 6개까지
			int lottoNum = (int)(Math.random() * 45 + 1);
			System.out.println("추첨번호 : " + lottoNum);
			lottoSet.add(lottoNum);
		}
		System.out.println("로또번호 : " + lottoSet);
		System.out.println("로또번호 갯수 : " + lottoSet.size());
		
		System.out.println("--------------------------");
		lottoSet.clear();
		System.out.println("로또번호 갯수 : " + lottoSet.size());
		while (lottoSet.size() < 6) { //set 데이터 6개까지
			lottoSet.add((int)(Math.random() * 45 + 1));
		}
		System.out.println("로또번호 : " + lottoSet);
		System.out.println("로또번호 갯수 : " + lottoSet.size());
		
		System.out.println("==== 로또번호 정렬 =====");
		ArrayList<Integer> list = new ArrayList<>(lottoSet);
		
		Collections.sort(list);
		System.out.println("금주의 로또번호 : " + list);
	}

}













