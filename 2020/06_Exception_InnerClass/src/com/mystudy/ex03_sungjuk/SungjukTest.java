package com.mystudy.ex03_sungjuk;

public class SungjukTest {

	public static void main(String[] args) {
		// StudentVO 타입의 데이터 1개 생성 후 국어점수, 영어점수 변경
		System.out.println("--- main() 시작 ---");
		StudentVO stu = new StudentVO("홍길동", 100, 90, 80);
		System.out.println(stu.toString());
		
		boolean result = stu.setKor(90); //잘못된 점수 입력
		if (!result) {
			System.out.println("[예외발생] 수정 실패" );
		}
		System.out.println("수정결과: " + stu.toString());
		
		System.out.println("====================");
		System.out.println("--- setEng() 처리 ---");
		
		try {
			stu.setEng(888);
		} catch (JumsuOutOfRangeException e) {
			System.out.println("[예외발생] " + e.getMessage());
		} catch (SungjukProcessException e) {
			System.out.println("[예외발생] 성적처리중 예외 발생");
		} catch (Exception e) {
			System.out.println("[예외발생] 예외 발생");
		}
		System.out.println("영어수정결과: " + stu);
		
		System.out.println("--- main() 끝 ---");
	}

}











