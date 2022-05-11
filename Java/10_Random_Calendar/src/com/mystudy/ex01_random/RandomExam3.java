package com.mystudy.ex01_random;

import java.util.Calendar;
import java.util.Random;

public class RandomExam3 {

	public static void main(String[] args) {
		// (실습) 오늘 당신의 행운지수 알아보기(0~100)
		// Math.random(), Random 사용해서 행운지수 값 만들기
		// 실행결과
		// 2020년 5월 8일 당신의 행운지수(0~100)는 77입니다
		//----------------------------------
		
		//년, 월, 일 구하기
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1; //0~11
		int date = calendar.get(Calendar.DATE);
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("date: " + date);
		String yyyymmdd = year + "년 " + month + "월 " + date + "일";

		int result = 0;
		//실습1 - Random nextInt(숫자)
		Random ran = new Random();
		result = ran.nextInt(101); //0~100 
		System.out.println(yyyymmdd + " 당신의 행운지수(0~100)는 "
				+ result + "입니다.");
		
		//실습2 - Math.random()
		result = (int)(Math.random() * 101);
		System.out.println(yyyymmdd + " 당신의 행운지수(0~100)는 "
				+ result + "입니다.");
		
		//(번외) Random nextInt() : Math.abs() - 절대값
		result = Math.abs(ran.nextInt()) % 101;
		System.out.println(yyyymmdd + " 당신의 행운지수(0~100)는 "
				+ result + "입니다.");
	}

}










