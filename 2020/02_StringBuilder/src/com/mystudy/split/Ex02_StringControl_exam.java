package com.mystudy.split;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 문자열 다루기
0.문자열 데이터
  String str1 = "홍길동 이순신   이순신 Tom 홍길동";
  String str2 = "    TOM    을지문덕 김유신 연개소문";
1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
2-1. sb의 문자열을 빈칸(" ")을 구분자로 잘라서 이름만 추출 후 화면 출력(데이타확인)
     (String.split() 또는 StringTokenizer 클래스 사용)
      예) 홍길동 이순신 이순신 Tom 홍길동 TOM...
2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
      예) 홍길동,이순신,이순신,Tom,홍길동,TOM...   
4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
      예) 홍,이,이,T,홍,T,을... 
5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
      예) 인덱스번호:을지문덕
------------------------------------- */
public class Ex02_StringControl_exam {

	public static void main(String[] args) {
		String str1 = "홍길동 이순신   이순신 Tom 홍길동";
		String str2 = "    TOM    을지문덕 김유신 연개소문";
		//1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		//StringBuilder sb = new StringBuilder(str1 + str2);
//		StringBuilder sb = new StringBuilder();
//		sb.append(str1);
//		sb.append(str2);
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println("sb : " + sb.toString());
		
//		2-1. sb의 문자열을 빈칸(" ")을 구분자로 잘라서 이름만 추출 후 화면 출력(데이타확인)
//	     (String.split() 또는 StringTokenizer 클래스 사용)
//	          예) 홍길동 이순신 이순신 Tom 홍길동 TOM...
		StringTokenizer stk = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰갯수 : " + stk.countTokens());
		while (stk.hasMoreTokens()) {
			System.out.print(stk.nextToken() + " ");
		}
		System.out.println();
		System.out.println("토큰갯수 : " + stk.countTokens());
		
		//2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		stk = new StringTokenizer(sb.toString(), " ");
		String[] names = new String[stk.countTokens()];
		System.out.println("names 크기 : " + names.length);
		//토큰을 배열에 저장
		int index = 0;
		while (stk.hasMoreTokens()) {
			names[index] = stk.nextToken();
			index++;
		}
		System.out.println(Arrays.toString(names));
		
//		3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
//	      예) 홍길동,이순신,이순신,Tom,홍길동,TOM...
		System.out.println("---- 3번 ----");
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i]);
				sb1.append(names[i]);
			} else {
				System.out.print("," + names[i]);
				//sb1.append("," + names[i]);
				sb1.append(",").append(names[i]);
			}
		}
		System.out.println();
		System.out.println("-----");
		System.out.println("sb1 : " + sb1);
		
		System.out.println("====== 4번 ================");
//		4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
//	      예) 홍,이,이,T,홍,T,을... 
		sb1.setLength(0); //전체데이타 삭제 처리
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				sb1.append(names[i].charAt(0));
			} else {
				sb1.append(",").append(names[i].charAt(0));
			}
		}
		System.out.println("sb1 : " + sb1);
		System.out.println();
		
		System.out.println("======= 5번 =============");
//		5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
//	         예) 인덱스번호:을지문덕
		sb1.setLength(0);
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				//System.out.println(i + ":" + names[i]);
				sb1.append(i).append(":").append(names[i]).append("\n");
			}
		}
		System.out.println("sb1: " + sb1);
		
		//============================================
		System.out.println("=========== split() 사용시 ============");
		System.out.println("sb : " + sb);
		String[] names2 = sb.toString().split(" ");
		for (int i = 0; i < names2.length; i++) {
			System.out.println(i + " : -" + names2[i] + "-");
		}
		System.out.println("---이름만 출력 ---");
		for (int i = 0; i < names2.length; i++) {
			if (!names2[i].equals("")) { //같은 문자열 인지 확인
				System.out.println(i + " : -" + names2[i] + "-");
			}
		}
		System.out.println("-----");
		for (int i = 0; i < names2.length; i++) {
			if (names2[i].length() > 0) { //크기비교
				System.out.println(i + " : -" + names2[i] + "-");
			}
		}
		
	}//end main

}//end class













