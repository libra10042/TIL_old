package com.mystudy.ex05_hashset;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExam_Lotto {

	public static void main(String[] args) {
		//TreeSet : 데이터를 저장할 때 정렬해서 저장
		
		/* (실습) Set을 이용한 로또만들기(TreeSet)
		로또번호 : 1 ~ 45 랜덤숫자 6개를 Set에 저장
		로또번호 6개를 추첨, 작은 숫자부터 순서대로 화면 출력
		- Math.random() 사용해서 랜덤한 숫자 만들기
		  (int)(Math.random() * 45 + 1)
		- 출력은 작은 숫자부터 큰숫자 형태로
		    출력예) 금주의 로또번호 : 5, 8, 10, 25, 33, 41
		******************************** */
		Set<Integer> lottoSet = new TreeSet<>();
		System.out.println("로또번호 갯수 : " + lottoSet.size());
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
		while (lottoSet.size() < 6) { //set 데이터 6개까지
			lottoSet.add((int)(Math.random() * 45 + 1));
		}
		System.out.println("로또번호 : " + lottoSet);
		System.out.println("로또번호 갯수 : " + lottoSet.size());
		
	}

}










