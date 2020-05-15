package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam1 {

	public static void main(String[] args) {
		// Scanner : 주로 콘솔(화면)에서 값을 입력받아 처리할 때 사용
		Scanner scan = new Scanner(System.in);
		
		//inputString(scan);
		
		System.out.println("=========================");
//		int num1 = 100;
//		int num2 = 200;
//		int sum = num1 + num2;
//		System.out.println("sum : " + sum);
		
		System.out.print("> 숫자 입력1 : ");
		int num1 = scan.nextInt();
		
		System.out.print("> 숫자 입력2 : ");
		int num2 = scan.nextInt();
		
		int sum = num1 + num2;
		System.out.println("합계결과 : " + sum);
		
		System.out.println("==================");
		//주의 : nextInt(), nextLine()메소드 연속사용시 문제발생
		//     nextLine()이 값을 읽지 못하는 문제발생
		System.out.print(">> 숫자입력 : ");
		int num3 = scan.nextInt();
		scan.nextLine(); //줄바꿈 문자 앞쪽까지 읽기(줄바꿈 이전까지 읽기)
		
		System.out.print(">> 문자열(숫자) 입력 : ");
		int num4 = Integer.parseInt(scan.nextLine());
		
		System.out.println();
		System.out.println("num3: " + num3 + ", num4: " + num4);
		sum = num3 + num4;
		System.out.println("num3 + num4 : " + sum);
		
		System.out.println("\n--- main() 끝 ---");
	}
	
	static void inputString(Scanner scan) {
		System.out.print("문자열 입력1 : ");
		String str1 = scan.nextLine();
		System.out.println(">>> " + str1);
		
		System.out.println("-----");
		System.out.print("문자열 입력2 : ");
		String str2 = scan.nextLine();
		System.out.println(">>> " + str2);
	}

}











