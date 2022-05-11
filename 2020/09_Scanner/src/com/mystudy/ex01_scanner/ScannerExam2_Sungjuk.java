package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam2_Sungjuk {

	public static void main(String[] args) {
		// 성명, 국어, 영어, 수학 점수를 화면(콘솔)에서 입력받아
		// 총점, 평균을 구하고 결과 화면 출력
		// (한 번 실행 후 선택적으로 반복 처리)
		/*
		성명 : 홍길동
		국어 : 100
		영어 : 90
		수학 : 81
		----------
		총점 : 271
		평균 : 90.33
		***********************/
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			//화면에서 데이터 입력 받기
			System.out.print("성명 : ");
			String name = scan.nextLine();
			
			int kor = inputScore(scan, "국어");
//			System.out.print("국어점수 : ");
//			int kor = scan.nextInt();
			
			System.out.print("영어점수 : ");
			int eng = scan.nextInt();
			
			System.out.print("수학점수 : ");
			int math = scan.nextInt();
			scan.nextLine();
			
			//입력값에 대한 계산 처리
			int tot = kor + eng + math;
			double avg = tot * 100 / 3 / 100.0;
			
			//성적 결과 출력
			System.out.println("\n=== 성적 결과 ===");
			System.out.println("성명 : " + name);
			System.out.println("국어 : " + kor);
			System.out.println("영어 : " + eng);
			System.out.println("수학 : " + math);
			System.out.println("-----------");
			System.out.println("총점 : " + tot);
			System.out.println("평균 : " + avg);
			System.out.println("==============");
			System.out.println();
		
			//성적처리 계속 여부 확인
			System.out.print("계속 작업 하시겠습니까?(y:계속작업, n:중단) ");
			String answer = scan.nextLine();
			if ("N".equalsIgnoreCase(answer)) {
				System.out.println(">> 작업이 종료되었습니다.");
				break;
			}
			System.out.println(">> 성적처리를 계속합니다. 데이터를 입력하세요~~");
		}
	}
	
	static int inputScore(Scanner scan, String subject) {
		int result = -1;
		
		while (true) {
			System.out.print(subject + "점수 : ");
			try {
				result = Integer.parseInt(scan.nextLine());
				if (result < 0 || result > 100) {
					System.out.println("[오류] 범위(0~100) 벗어난 값입니다. 다시 입력하세요.");
					continue;
				}
				break; //정상적인 숫자값 입력되면
			} catch(Exception e) {
				System.out.println("[예외발생] 잘못된 값입니다. 다시 입력하세요");
			}
		}
		
		return result;
	}

}













