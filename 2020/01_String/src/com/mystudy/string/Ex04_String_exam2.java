package com.mystudy.string;

import java.util.Arrays;

public class Ex04_String_exam2 {

	public static void main(String[] args) {
		/* String 사용 실습
		문자열 : "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		/////////-배열 선언중괄호로 변수값넣기
		1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
		2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력 예) 홍길동,이순신,이순신,을지문덕....
		3. 배열에 있는 데이타의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		   출력 예) 홍,이,이,을,김,연,T,T...
		4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
		   예) 3(인덱스번호):을지문덕
		5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
		   예) 1:이순신=2:이순신
		(기타) 이름 비교시에는 대소문자 구분 없이 비교처리(Tom, TOM 은 같다)
		========================================================= */
		//1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
//		String[] names = new String[8];
//		names[0] = "홍길동";
//		names[1] = "이순신";
		String[] names = {"홍길동","이순신","이순신","을지문덕","김유신",
				"연개소문","Tom","TOM"};
		System.out.println(Arrays.toString(names));
		
//		2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
//		   출력 예) 홍길동,이순신,이순신,을지문덕....
		//names[0] + "," + names[1] + "," + names[2] + "," ... + names[7]
		if (names.length > 0) {
			System.out.print(names[0]);
		}
		for (int i = 1; i < names.length; i++) {
			System.out.print("," + names[i]);
		}
		System.out.println();
		System.out.println("---- 배열의 첫번째 여부 확인 ---");
		//첫 번째 반복문 실행 여부를 판단해서 구분 처리
		boolean isFirst = true;
		for (int i = 0; i < names.length; i++) {
			if (isFirst) {
				System.out.print(names[i]);
				isFirst = false;
			} else {
				System.out.print("," + names[i]);
			}
		}
		System.out.println();
		
		System.out.println("---- 배열의 마지막 여부 확인 ---");
		for (int i = 0; i < names.length; i++) {
			if (i == (names.length - 1)) {
				System.out.print(names[i]);
			} else {
				System.out.print(names[i] + ",");
			}
		}
		System.out.println();
		
		System.out.println("===== 3번 ============");
//		3. 배열에 있는 데이타의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
//		   출력 예) 홍,이,이,을,김,연,T,T...
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i].charAt(0));
			} else {
				System.out.print("," + names[i].charAt(0));
			}
		}
		System.out.println();
		
		System.out.println("==== 4번 ===========");
//		4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
//		   예) 3(인덱스번호):을지문덕
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.println(i + ":" + names[i]);
			}
		}
		System.out.println();
		
		System.out.println("===== 5번 ==========");
//		5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
//		   예) 1:이순신=2:이순신
//		(기타) 이름 비교시에는 대소문자 구분 없이 비교처리(Tom, TOM 은 같다)
		//홍길동,이순신,이순신,을지문덕,김유신,연개소문,Tom,TOM
		//기준인덱스 : 0
		if (names[0].equalsIgnoreCase(names[1])) {
			System.out.println(0 + ":" + names[0] + "=" + 1 + ":" + names[1]);
		}
		if (names[0].equalsIgnoreCase(names[2])) {
			System.out.println(0 + ":" + names[0] + "=" + 2 + ":" + names[2]);
		}
		if (names[0].equalsIgnoreCase(names[3])) {
			System.out.println(0 + ":" + names[0] + "=" + 3 + ":" + names[3]);
		}
		//....
		if (names[0].equalsIgnoreCase(names[names.length - 1])) {
			System.out.println(0 + ":" + names[0] 
					+ "=" + (names.length - 1) + ":" + names[names.length - 1]);
		}
		
		//기준인덱스 : 1 -------------------
		if (names[1].equalsIgnoreCase(names[2])) {
			System.out.println(1 + ":" + names[1] + "=" + 2 + ":" + names[2]);
		}
		if (names[1].equalsIgnoreCase(names[3])) {
			System.out.println(1 + ":" + names[1] + "=" + 3 + ":" + names[3]);
		}
		//...
		if (names[1].equalsIgnoreCase(names[names.length - 1])) {
			System.out.println(1 + ":" + names[1] 
					+ "=" + (names.length - 1) + ":" + names[names.length - 1]);
		}
		System.out.println("===============");
		for (int i = 1; i < names.length; i++) {
			if (names[0].equalsIgnoreCase(names[i])) {
				System.out.println(0 + ":" + names[0] + "=" + i + ":" + names[i]);
			}
		}
		for (int i = 2; i < names.length; i++) {
			if (names[1].equalsIgnoreCase(names[i])) {
				System.out.println(1 + ":" + names[1] + "=" + i + ":" + names[i]);
			}
		}
		//.....
		//기준인덱스 : 맨마지막 이전 데이터
		for (int i = names.length - 1; i < names.length; i++) {
			if (names[names.length-2].equalsIgnoreCase(names[i])) {
				System.out.println((names.length-2) + ":" + names[names.length-2] + "=" + i + ":" + names[i]);
			}
		}
		
		System.out.println("==== 이중 for문으로 ====");
		for (int gijun = 0; gijun < names.length-1; gijun++) {
			for (int i = (gijun+1); i < names.length; i++) {
				if (names[gijun].equalsIgnoreCase(names[i])) {
					System.out.println(gijun + ":" + names[gijun] 
							+ "=" + i + ":" + names[i]);
				}
			}
		}
		
		
	}

}













