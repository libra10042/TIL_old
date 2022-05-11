package com.mystudy.ex02_calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new Date() : " + date);
		
		//월 : 0~11 - 0:1월, 1:2월, ...., 11: 12월
		date = new Date(2020 - 1900, 4, 11); //년도 1900 기준 지난 햇수
		date = new Date(120, 4, 11);//년도 1900 기준 + 지난 햇수
		System.out.println("date : " + date);
		
		//----------------------------
		System.out.println("==== Calendar =======");
		Calendar cal = Calendar.getInstance();
		System.out.println("Calendar : " + cal);
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		System.out.println("월 : " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		System.out.println("일 : " + cal.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("오전오후 : " + cal.get(Calendar.AM_PM)); //0, 1
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR)); //0~11		
		System.out.println("시(24시간) : " + cal.get(Calendar.HOUR_OF_DAY)); //0~23	
		System.out.println("분 : " + cal.get(Calendar.MINUTE)); //0~59	
		System.out.println("초 : " + cal.get(Calendar.SECOND)); //0~59	
		System.out.println("밀리초 : " + cal.get(Calendar.MILLISECOND)); //0~999	
		
		System.out.println("=============================");
		// 년-월-일 시:분:초      년/월/일 시:분:초
		//2020-05-11 10:11:30
		String dateTime = cal.get(Calendar.YEAR)
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		System.out.println("년-월-일 시:분:초 >> " + dateTime);
		System.out.println("getDateTime() >> " + getDateTime());
		
		System.out.println("\n====== SimpleDateFormat ======");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		date = new Date();
		System.out.println("date : " + date);
		System.out.println("yyyy-MM-dd hh:mm:ss >> " + sdf.format(date));
		
	}
	
	static String getDateTime() {
		Calendar cal = Calendar.getInstance();
		//cal.set(2020, 4, 5, 15, 5, 5);
		
		String dateTime = "";
		int month = cal.get(Calendar.MONTH) + 1;
		String mm = "";
//		if (month < 10) {
//			mm = "0" + month; // 5 -> 05
//		} else {
//			mm = "" + month;
//		}
		mm = (month < 10) ? "0" + month : "" + month;
		
		int date = cal.get(Calendar.DAY_OF_MONTH);
		String dd = (date < 10) ? "0" + date : String.valueOf(date);
		
		dateTime = cal.get(Calendar.YEAR)
				+ "-" + mm
				+ "-" + dd
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		
		return dateTime;
	}

}














