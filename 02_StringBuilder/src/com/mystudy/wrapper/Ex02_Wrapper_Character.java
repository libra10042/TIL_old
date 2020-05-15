package com.mystudy.wrapper;

public class Ex02_Wrapper_Character {

	public static void main(String[] args) {
		// Character 클래스
		char ch = 'a'; // "a"와 'a' 서로 다른 타입
		System.out.println(Character.isAlphabetic(ch)); //true
		System.out.println("Character.isAlphabetic('한') : "
				+ Character.isAlphabetic('한')); //true
		System.out.println("Character.isAlphabetic('0') : "
				+ Character.isAlphabetic('0')); //false
		System.out.println("-----------------------");
		System.out.println(Character.isLetter('0')); //false
		System.out.println(Character.isDigit('0')); //true
		System.out.println(Character.isUpperCase('A')); //true
		System.out.println(Character.isUpperCase('a')); //false
		System.out.println(Character.isLowerCase('a')); //true
		System.out.println(Character.isWhitespace(' ')); //true
		System.out.println(Character.isWhitespace('\t')); //true
		System.out.println(Character.isWhitespace('A')); //false
		
		System.out.println("======================");
		char[] chs = {'한', 'a', 'A', '+', '0', ' '};
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + ":");
			if (Character.isDigit(chs[i])) {
				System.out.print(" 숫자");
			}
			if (Character.isWhitespace(chs[i])) {
				System.out.print(" Ws(빈칸,탭..)");
			}
			if (Character.isUpperCase(chs[i])) {
				System.out.print(" 대");
			}
			if (Character.isLowerCase(chs[i])) {
				System.out.print(" 소");
			}
			if (Character.isLetter(chs[i])) {
				System.out.print(" 문자");
			}
			if (Character.isDefined(chs[i])) {
				System.out.print(" 유니코드입니다.");
			}
			System.out.println();
		}
		
	}

}









