package com.mystudy.string;

import java.util.Arrays;

public class Ex02_String_method {

	public static void main(String[] args) {
		// charAt()
		System.out.println("--- charAt() ---");
		String str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.toString() : " + str.toString());
		
		char ch = str.charAt(0);
		System.out.println("str.charAt(0) : " + ch);
		
		// 문자열 중 앞의 4글자 추출
		char[] ch2 = new char[4];
		System.out.println(Arrays.toString(ch2));
		for (int i = 0; i < ch2.length; i++) {
			ch2[i] = str.charAt(i);
		}
		System.out.println(Arrays.toString(ch2)); //[J, a, v, a]
		
		System.out.println("---- compareTo() ----");
		System.out.println("java vs java : " + "java".compareTo("java"));
		System.out.println("\"a\".compareTo(\"b\") : " + "a".compareTo("b")); //-1
		System.out.println("a".compareTo("a")); //0
		System.out.println("b".compareTo("a")); //1
		System.out.println("c".compareTo("a")); //2

		System.out.println("--- copyValueOf() ---");
		char[] ch3 = {'a', 'b', 'c', 'd'};
		System.out.println("ch3 : " + Arrays.toString(ch3));
		String str3 = String.copyValueOf(ch3);
		System.out.println("String.copyValueOf(ch3) : " + str3);
		
		// 시작 문자열 여부 확인
		System.out.println("--- startsWith() ---");
		System.out.println("str3 : " + str3);
		System.out.println("str3.startsWith(\"ab\") : " + str3.startsWith("ab"));
		System.out.println("str3.startsWith(\"ac\") : " + str3.startsWith("ac"));
		
		System.out.println("--- indexOf() ---");
		String str4 = "Java World";
		System.out.println("str4 : " + str4);
		// 찾는 문자, 문자열이 없으면 -1 값 리턴
		System.out.println("str4.indexOf('X') : " + str4.indexOf('X'));
		System.out.println("str4.indexOf('a') : " + str4.indexOf('a'));
		System.out.println("str4.indexOf(\"World\") : " 
				+ str4.indexOf("World"));
		System.out.println("str4.indexOf('a', 2) : " + str4.indexOf('a', 2));
		
		System.out.println("--- isEmpty() ----");
		//str4 = "";
		System.out.println("str4.isEmpty() : " + str4.isEmpty());
		
		System.out.println("--- replace() ---");
		System.out.println("str4 : " + str4);
		System.out.println("str4.replace('a', 'b') : " + str4.replace('a', 'b'));
		System.out.println("str4 : " + str4); //str4 데이타는 그대로 유지
		
		System.out.println("---replaceAll(), replaceFirst() --- ");
		str4 = "java java";
		System.out.println("str4 : " + str4);
		System.out.println("str4.replace(\"ja\", \"JA\") : " + str4.replace("ja", "JA"));
		System.out.println("str4.replaceAll(\"ja\", \"JA\") : " + str4.replaceAll("ja", "JA"));
		
		System.out.println("str4.replaceFirst(\"ja\", \"JA\") : " + str4.replaceFirst("ja", "JA"));
		System.out.println("str4 : " + str4);
		
		System.out.println("==== substring() =======");
		//     01234587890
		str = "Java World~~~";
		System.out.println("str : " + str);
		System.out.println(str.substring(0)); //0번 인덱스부터 끝까지 추출
		System.out.println(str.substring(5)); //5번 인덱스부터 끝까지 추출
		
		//beginIndex : 시작위치 값 부터(포함)
		//endIndex : end 이전까지(불포함)
		System.out.println(str.substring(1, 4)); //인덱스 1부터 3까지 추출(4이전)
		System.out.println("World 추출 : " + str.substring(5, 10));
		System.out.println("str.length() : " + str.length());
		System.out.println(str.substring(0, str.length()));
		
		//뒤에서 3개 문자열을 제외하고
		System.out.println(str.substring(0, str.length() - 3));
		
		//문자열 -> char[]
		System.out.println("--- toCharArray() ----");
		System.out.println("str : " + str);
		char[] ch4 = str.toCharArray();
		System.out.println(ch4);
		System.out.println("ch4 : " + Arrays.toString(ch4));
		System.out.println(ch4[0]);
		System.out.println(ch4[1]);
		
		System.out.println("--- toUpperCase(), toLowerCase(), trim() ---");
		str = "   Java World   ";
		System.out.println("str : -" + str + "-");
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		System.out.println("trim() : -" + str.trim() + "-");
		
		System.out.println("---- String.valueOf() ----");
		int num = 100;
		System.out.println(num + 1);
		System.out.println("" + num + 1);
		System.out.println(String.valueOf(num) + 1);
		
		String snum = String.valueOf(100); // 100 --> "100" 타입전환
		String bstr = String.valueOf(true); // true --> "true" 타입전환
		if ("true".equals(bstr)) {
			System.out.println("문자열 \"true\"와 bstr에 있는 문자열은 같은 \"true\"");
		}
	}

}












