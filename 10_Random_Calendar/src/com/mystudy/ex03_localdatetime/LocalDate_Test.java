package com.mystudy.ex03_localdatetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class LocalDate_Test {

	public static void main(String[] args) {
		// Calendar : 객체에 저장된 데이터가 변경됨(Muttable)
		Calendar now = Calendar.getInstance();
		System.out.println("Calendar.getInstance() : " + now);
		now.add(Calendar.DATE, 3); //3일 뒤
		now.add(Calendar.MONTH, 3); //3달 후
		System.out.println("3달 후 3일 후(변경후) : " + now);
		
		System.out.println("===== LocalDate ====");
		//Java8 LocalDate : 값이 변경되지 않음(immutable)
		LocalDate nowDate = LocalDate.now();
		System.out.println("LocalDate.now() : " + nowDate);
		System.out.println(nowDate.getYear());
		System.out.println(nowDate.getMonthValue()); //1~12월
		System.out.println(nowDate.getDayOfMonth()); 
		
		System.out.println("LocalDate 전 : " + nowDate);
		LocalDate newdt = nowDate.plusYears(2).plusMonths(2).plusDays(-2);
		System.out.println("LocalDate 후 : " + nowDate);
		System.out.println("새로운 newdt : " + newdt);
		
		System.out.println("==== LocalTime =====");
		LocalTime nowTime = LocalTime.now();
		System.out.println("LocalTime.now() : " + nowTime);
		System.out.println(nowTime.getHour()); //0~23
		System.out.println(nowTime.getMinute()); //0~59
		System.out.println(nowTime.getSecond()); //0~59
		System.out.println(nowTime.getNano()); //0~999,999,999
		
		System.out.println("----------");
		System.out.println("LocalTime.now() : " + nowTime);
		LocalTime newTime = nowTime.plusHours(-10)
				.plusMinutes(2).plusSeconds(-10);
		System.out.println("nowTime : " + nowTime);
		System.out.println("newTime  : " + newTime);
	}

}











