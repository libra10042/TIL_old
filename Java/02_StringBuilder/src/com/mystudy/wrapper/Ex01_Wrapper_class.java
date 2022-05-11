package com.mystudy.wrapper;

public class Ex01_Wrapper_class {

	public static void main(String[] args) {
		/* Wrapper 클래스 : 기본데이타 타입의 클래스 타입들의 총칭
		기본데이타 타입 (전체소문자) : 
		 	boolean, char, byte, short, int, long, float, double
		Wrapper class : 기본데이터 타입의 첫글자를 대문자로 작성
			예외 : char -> Character, int -> Integer
			Boolean, Byte, Short, Long, Float, Double
		--------------------------------------------*/
		int num = 100;
		System.out.println("num : " + num);
		
		//Integer intNum = 100; //사용가능 : 자동 형변환
		Integer intNum = new Integer(100);
		System.out.println("intNum : " + intNum);
		
		//intNum = "100"; //Type mismatch: cannot convert from String to Integer
		intNum = new Integer("100");
		
		intNum = 900; //Integer <- int : 자동형변환
		num = intNum; //int <- Integer : 자동형변환
		
		System.out.println("정수 int 최대값 : " + Integer.MAX_VALUE);
		System.out.println("정수 int 최소값 : " + Integer.MIN_VALUE);
		
		num = Integer.parseInt("999"); //int 타입 <- 문자열(String)
		intNum = Integer.valueOf("999"); //Integer 타입 <- 문자열(String)
		System.out.println("num + 1 : " + (num + 1));
		System.out.println("intNum + 1 : " + (intNum + 1));
		
		System.out.println("----- Boolean -----");
		Boolean bool = true;
		bool = new Boolean(true);
		bool = new Boolean("true"); // true <- "true"
		System.out.println("bool : " + true);
		if (bool) {
			System.out.println("bool 값은 Boolean true");
		}
		System.out.println("--- new Boolean(\"true1\") ---");
		bool = new Boolean("true1"); //대소문자 구분없이 true 값만 true
		System.out.println("bool : " + bool);
		
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		
		System.out.println("------- Float, Double 동일 ---------");
		Float f = 10.5f; //Float <= float
		f = new Float(12.5f);
		f = new Float("12.5f");
		System.out.println("new Float(\"12.5f\") : " + f);
		
		String str = String.valueOf(10.5f); //String <- float
		str = String.valueOf(f); //String <- Float
		System.out.println("str : " + str);
		
		f = Float.valueOf(str); //Float <- String
		System.out.println("f : " + f);
	}

}












