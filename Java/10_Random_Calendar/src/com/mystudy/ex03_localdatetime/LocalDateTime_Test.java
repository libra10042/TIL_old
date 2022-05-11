package com.mystudy.ex03_localdatetime;

import java.time.LocalDateTime;

public class LocalDateTime_Test {

	public static void main(String[] args) {
		// LocalDateTime : ��¥, �ð� ������ ����(������ �Һ�)
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
		LocalDateTime newDateTime = nowDateTime.plusYears(3); //3�� ��
		System.out.println("nowDateTime : " + nowDateTime);
		System.out.println("newDateTime : " + newDateTime);
		
		newDateTime = newDateTime.plusMonths(-4); //4���� ��
		System.out.println("newDateTime : " + newDateTime);
	}

}





















