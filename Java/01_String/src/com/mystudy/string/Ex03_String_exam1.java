package com.mystudy.string;

public class Ex03_String_exam1 {

	public static void main(String[] args) {
		/* (실습) String 클래스의 메소드를 사용
		String str = "940108-1234567"; //주민등록번호 체계
		1. 정확히 입력된 데이타인지 확인
		   (전체자리수: 14 자리, '-'위치 : 7번째인지 확인)
		2. 생년월일 출력(1-2번째: 년도, 3-4번째: 월, 5-6번째: 일)
			예)900108 -> 90년 01월 08일 또는 90년 1월 8일
		3. 성별확인하고 출력(1,3: 남성, 2,4: 여성)
		4. 데이타 값 검증(월: 1~12, 일: 1~31)
		참고 : int num = Integer.parseInt("12") : "12" -> 12(문자열->숫자)
		-------------------------------------*/
		String str = "940108-1234567";
		System.out.println("str : " + str);
		
		//1. 정확히 입력된 데이타인지 확인
		//전체자리수: 14 자리
		System.out.println("str.length() : " + str.length());
		int length = str.length();
		if (length == 14) {
			System.out.println("[정상] 전체길이 14자리");
		} else {
			System.out.println("[비정상] 전체길이 " + str.length());
			System.out.println(">> 잘못된 데이타가 입력되어 프로그램 종료!!");
			//return;
		}
		
		//'-'위치 : 7번째인지 확인(charAt, indexOf, substring)
		System.out.println("str.charAt(6) : " + str.charAt(6));
		if (str.charAt(6) == '-') {
			System.out.println("[정상] '-' 문자위치 7번째");
		} else {
			System.out.println("[정상] '-' 문자위치 7번째 아님");
		}
		
		//'-'위치 : 7번째인지 확인(indexOf)
		System.out.println(str.indexOf('-'));
		if (str.indexOf('-') != 6) { //비정상인 경우
			System.out.println("[비정상] '-' 문자위치 7번째 아님");
		}
		//'-'위치 : 7번째인지 확인(substring)
		System.out.println(str.substring(6, 7));
		if (str.substring(6, 7).equals("-")) {
			System.out.println("[정상substring] '-' 문자위치 7번째");
		} else {
			System.out.println("[정상substring] '-' 문자위치 7번째 아님");
		}
		
		//2. 생년월일 출력(1-2번째: 년도, 3-4번째: 월, 5-6번째: 일)
		//	예)900108 -> 90년 01월 08일 또는 90년 1월 8일
		//String str = "940108-1234567";
		String yymmdd = str.substring(0, 6);
		System.out.println("yymmdd : " + yymmdd);
		String yy = yymmdd.substring(0, 2);
		String mm = yymmdd.substring(2, 4);
		String dd = yymmdd.substring(4, 6);
		
		System.out.println("생년월일 : " + yy +"년 "+ mm +"월 "+ dd +"일");
		
		//3. 성별확인하고 출력(1,3: 남성, 2,4: 여성) --------------------
		String gender = str.substring(7, 8);
		System.out.println("성별 : " + gender);
		//if (gender.equals("1") || "3".equals(gender)) {
		if ("1".equals(gender) || "3".equals(gender)) {
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "(남성)");
		} else if ("2".equals(gender) || "4".equals(gender)) {
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "(여성)");
		} else {
			System.out.println("[비정상] 주민번호 뒷자리(첫글자) : " + gender);
		}
		
		switch (gender) {
		case "1": case "3":
			System.out.println("주민번호 뒷자리-첫글자 : " + gender + "(남성)");
			break;
		case "2": case "4":
			System.out.println("주민번호 뒷자리-첫글자 : " + gender + "(여성)");
			break;
		default:
			System.out.println("외국인????");
		}
		
		System.out.println("=========================");
		//4. 데이타 값 검증(월: 1~12, 일: 1~31) ------------------------
		//              0123456
		//String str = "940108-1234567";
		String sMonth = str.substring(2, 4);
		System.out.println("str.substring(2, 4) : " + str.substring(2, 4));
		int month = Integer.parseInt(sMonth);
		if (month >= 1 && month <= 12) {
			System.out.println("[정상] 월 데이타(1~12)");
		} else {
			System.out.println("[비정상] 월 데이타 1~12 범위가 아님");
		}
		if (month < 1 || month > 12) {
			System.out.println("[비정상] 월 데이타 1~12 범위가 아님");
		}

		//일자확인 : 1~31 범위여부
		int date = Integer.parseInt(str.substring(4, 6));
		if (date >= 1 && date <= 31) {
			System.out.println("[정상] 일 데이타(1~31)");
		} else {
			System.out.println("[비정상] 일 데이타 1~31 범위 아님");
		}
		
		
		System.out.println("--- main() 종료 ---");
	}

}














