package com.mystudy.ex03_localdatetime;

import java.time.LocalDateTime;

public class LocalDateTime_Test {

	public static void main(String[] args) {
		// LocalDateTime : 날짜, 시간 정보를 가짐(데이터 불변)
		LocalDateTime nowDateTime = LocalDateTime.now();
		System.out.println("LocalDateTime.now() : " + nowDateTime);

		System.out.println(nowDateTime.getYear());
		System.out.println(nowDateTime.getMonthValue());
		System.out.println(nowDateTime.getDayOfMonth());
		System.out.println(nowDateTime.getHour());
		System.out.println(nowDateTime.getMinute());
		System.out.println(nowDateTime.getSecond());
		System.out.println(nowDateTime.getNano());
		
		System.out.println("---------");
		LocalDateTime newDateTime = nowDateTime.plusYears(3); //3년 후
		System.out.println("nowDateTime : " + nowDateTime);
		System.out.println("newDateTime : " + newDateTime);
		
		newDateTime = newDateTime.plusMonths(-4); //4개월 전
		System.out.println("newDateTime : " + newDateTime);
	}

}





















