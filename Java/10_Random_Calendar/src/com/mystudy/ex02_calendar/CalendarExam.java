package com.mystudy.ex02_calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new Date() : " + date);
		
		//�� : 0~11 - 0:1��, 1:2��, ...., 11: 12��
		date = new Date(2020 - 1900, 4, 11); //�⵵ 1900 ���� ���� �޼�
		date = new Date(120, 4, 11);//�⵵ 1900 ���� + ���� �޼�
		System.out.println("date : " + date);
		
		//----------------------------
		System.out.println("==== Calendar =======");
		Calendar cal = Calendar.getInstance();
		System.out.println("Calendar : " + cal);
		System.out.println("�⵵ : " + cal.get(Calendar.YEAR));
		System.out.println("�� : " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("�� : " + cal.get(Calendar.DATE));
		System.out.println("�� : " + cal.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("�������� : " + cal.get(Calendar.AM_PM)); //0, 1
		System.out.println("��(12�ð�) : " + cal.get(Calendar.HOUR)); //0~11		
		System.out.println("��(24�ð�) : " + cal.get(Calendar.HOUR_OF_DAY)); //0~23	
		System.out.println("�� : " + cal.get(Calendar.MINUTE)); //0~59	
		System.out.println("�� : " + cal.get(Calendar.SECOND)); //0~59	
		System.out.println("�и��� : " + cal.get(Calendar.MILLISECOND)); //0~999	
		
		System.out.println("=============================");
		// ��-��-�� ��:��:��      ��/��/�� ��:��:��
		//2020-05-11 10:11:30
		String dateTime = cal.get(Calendar.YEAR)
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		System.out.println("��-��-�� ��:��:�� >> " + dateTime);
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














