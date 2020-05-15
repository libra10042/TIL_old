package com.mystudy.ex04_printwriter;

import java.util.Calendar;

public class Exam_printf {

	public static void main(String[] args) {
		// printf() 메소드
		int a = 20;
		long b = 300000000000L;
		float c = 34.95f;
		double d = 234.234;
		char e = 'A';
		String f = "Hello~~~";
		boolean g = false;
		
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.printf("%tF", today);
		System.out.println();
		
		System.out.println("---------------");
		System.out.println(">> " + a + " " + b + " " + c + " "
				+ d + " " + e + " " + f + " " + g);
		
		System.out.println("====== printf 적용 ======");
		/* printf 메소드의 형식 문자 작성 요령([] 옵션 생략가능)
		%[인덱스]$[-][크기]형식문자 : %, 형식문자 필수 작성
		- 정렬은 기본적으로 우측정렬
		- 좌측정렬 사용은 마이너스 부호 사용 : 예) %-10d
		*/
		System.out.printf("%d %d %f %f \n", a, b, c, d);
		System.out.printf("%c %s %b %n", e, f, g);
		System.out.printf("%d %d %c %s \n", 100, 100, 'A', "Hllo~");
		
		//%[인덱스]$[-][크기]형식문자 : %, 형식문자 필수 작성
		System.out.println("---- 인덱스 사용예 ----");
		//System.out.printf("%d %d \n", 65); //1 대 1 매칭에서 데이터 부족 예외발생
		//(주의) 위치값 인덱스 적용하면 데이터 매칭에서 제외됨
		System.out.printf("%1$d %1$d %c %s\n", 67, 'B', "Hello~~");
		System.out.printf("%1$d %1$d %2$c %3$s\n", 67, 'B', "Hello~~");
		System.out.printf("%1$d %1$d %3$s %2$c \n", 67, 'B', "Hello~~");
		
		System.out.println("------ 실수형 데이터 --------");
		System.out.printf("%f %1$a %1$e %1$g \n", 65.1234567890123);
		System.out.println("123456789012345");
		System.out.printf("%1$10.4f\n", 65.1234567890123); //전체 10자리 소수점이하 4자리
		System.out.printf("%1$-10.4f\n", 65.1234567890123); //좌측정렬 전체 10자리 소수점이하 4자리
		
		System.out.println("------ 날짜관련 -----");
		System.out.printf("%1$tY/%1$tm/%1$td \n", today);
		System.out.printf("%1$tF \n", today);
		System.out.printf("%1$tI:%1$tM:%1$tS \n", today);
		
		System.out.println("----- 폭(width) 지정 ----");
		System.out.printf("%1$20f \n", 5678.12345678901234);
		System.out.printf("%1$-20f \n", 5678.12345678901234);
		System.out.printf("%1$-20.10f \n", 5678.12345678901234);
		
		System.out.println("---------------");
		System.out.printf("%-10s %10d %10d %10d \n", "aaaaaa", 100, 90, 80);
		System.out.printf("%-10s %10d %10d %10d \n", "bbbbb", 100, 90, 80);
		System.out.printf("%-10s %10d %10d %10d \n", "홍길동", 100, 90, 80);
		System.out.printf("%-10s %10d %10d %10d \n", "을지문덕", 100, 90, 80);
		
	}

}
















