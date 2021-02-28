package javaUtilExam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExam {
	public static void main(String[] args) {
		
		//현재 날짜와 시간
		LocalDateTime timePoint = LocalDateTime.now();
		
		//원하는 시간으로 time 객체 생성하는 방법. 
		LocalDate id1 = LocalDate.of(2012, Month.DECEMBER, 12);
		System.out.println(id1);
		
		// 17시 18분에 대한 LocalTime 객체를 구한다.
		LocalTime lt1 = LocalTime.of(17, 18);
		System.out.println(lt1);
		
		
		//10시 15분 30라는 문자열에 대한 LocalTime 객체를 구한다.
		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);
		
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);
		
		//Calender와 다르게 month + 1 을 하지 않아도 된다.
		Month month = timePoint.getMonth();
		System.out.println(timePoint.getMonthValue());
		System.out.println(month.getValue());
		System.out.println(timePoint.getHour());
		
		
		
	}
}
