package com.my.project.study;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myproject.vo.Doctor_Schedule;
import com.myproject.vo.Reserve;


public class Calendar {
	public static void main(String[] args) {
		List<Reserve> dateR = new ArrayList<>(); 
		List<Reserve> timeR = new ArrayList<>(); 
		//2017년 
		LocalDate localDate = LocalDate.of(2020, 7, 5);
		
		Month month = localDate.getMonth(); 
		System.out.println(month.getValue());
		
		//10시 5분 40초 표현. 
		LocalTime time = LocalTime.of(10, 5, 40);
		
		//LocalDateTime dateTime = LocalDateTime.of(localDate, time);
		//System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		
		for(int i=1; i<=7; i++) {
			LocalDate plusDays = localDate.plusDays(i);
			StringBuilder sb = new StringBuilder(); 
			sb.append(plusDays.format(DateTimeFormatter.ISO_DATE));
			System.out.println(sb.toString());
			//System.out.println(i + ". " + plusDays.format(DateTimeFormatter.ISO_DATE));
			
		}
		
		
		
		System.out.println("------------------------------------------");
		//int idx = 1; 
		for(int j=9; j<=17; j++) {
			StringBuilder sb2 = new StringBuilder(); 
			LocalTime timeSchedule = LocalTime.of(j, 00);
			sb2.append(timeSchedule);
			//System.out.println(idx + ". " + timeSchedule);
			//idx++;
			System.out.println(sb2);
		}
		
		
		
	}
	
}
//			//년, 월, 일 구하기
//			Calendar calendar = Calendar.getInstance();
//			int month = calendar.get(calendar.MONTH)+1;
//			int date = calendar.get(Calendar.DATE);
//			
//			
////			SimpleDateFormat formatter = new SimpleDateFormat("yyyy.mm.dd HH:MM", Locale.KOREA);
////			Date currentTime = new Date(); 
////			String dTime = formatter.format(currentTime);
////			System.out.println(dTime);
////			
////			
////			System.out.println(month + date);
////			
////			LocalDateTime currentDateTime = LocalDateTime.now(); 
////			
////			LocalDateTime targetDateTime = currentDateTime
////					.plusDays(1);
////			
////			LocalDate time= LocalDate.now();
////			LocalTime date= LocalTime.now(); 
////			
////			
//			for(int i= 1; i<=7; i++) {
//				calendar.add(Calendar.DATE, i); 
//				for(int j=9; j<=17; j++) {
//					calendar.add(Calendar.HOUR, j);
//				}
//				
//				System.out.println(calendar.DATE + ", " + calendar.HOUR);
//			}
//			
//			
//			
//			LocalDateTime nowDateTime = LocalDateTime.now(); 
//			System.out.println(nowDateTime.getMonthValue());
//			System.out.println(nowDateTime.getDayOfMonth());
//			System.out.println(nowDateTime.getHour());
//			
//			
//		
//		
//	}

