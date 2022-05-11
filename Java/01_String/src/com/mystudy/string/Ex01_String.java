package com.mystudy.string;

public class Ex01_String {

	public static void main(String[] args) {
		/* String 클래스 : 문자열 저장, 처리하기 위한 클래스
			String 값은 불변(immutable) : 값(데이타)를 변경할 수 없음
		사용형식 2가지
		String str = "홍길동"; //기본 데이타 타입 사용방식으로 사용 가능
		String str = new String("홍길동"); //객체(인스턴스) 생성 사용
		-------------------------- */
		String str1 = "Java";
		
		String strObj1 = new String("Java");
		System.out.println("str1 : " + str1);
		System.out.println("strObj1 : " + strObj1);
		
		String str11 = "Java";
		System.out.println("--------------");
		// == : 동일데이타(동일객체)여부 확인
		System.out.println("str1 == strObj1 : " + (str1 == strObj1));
		System.out.println("str1 == str11 : " + (str1 == str11));
		
		System.out.println("---- 문자열 값 비교(동일한 문자열) ---");
		System.out.println("str1.equals(strObj1) : " + str1.equals(strObj1));
		
		String strObj11 = new String("Java");
		System.out.println("strObj11 : " + strObj11);
		System.out.println("str1 == strObj11 : " + (str1 == strObj11));
		System.out.println("str1.equals(strObj11) : " + str1.equals(strObj11));
		System.out.println("-------");
		System.out.println("strObj1 == strObj11 : " + (strObj1 == strObj11));
		System.out.println("strObj1.equals(strObj11) : " + strObj1.equals(strObj11));
		
		System.out.println("--------");
		String str12 = "JAVA";
		System.out.println("str12 : " + str12);
		//                  "JAVA"   vs  "Java"
		System.out.println("str12.equals(strObj11) : " + str12.equals(strObj11));
		System.out.println("str12.equalsIgnoreCase(strObj11) : " 
				+ str12.equalsIgnoreCase(strObj11));
		
		//===============================
		System.out.println("----- concat() ------");
		String a = "Hello ";
		String b = "Java ";
		String c = "World!";
		System.out.println("a + b + c : " + (a + b + c));
		System.out.println("a.concat(b) : " + a.concat(b));
		
		//체이닝(chainning) 기법
		String result = a.concat(b).concat(c).concat("!!!");
		System.out.println(result);
	}

}




























