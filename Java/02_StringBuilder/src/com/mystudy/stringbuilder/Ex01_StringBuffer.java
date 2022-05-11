package com.mystudy.stringbuilder;

public class Ex01_StringBuffer {

	public static void main(String[] args) {
		// StringBuffer 클래스
		String str1 = "Hello"; //String <- "Hello" String타입
		String str = new String("Hello Java!!!");
		System.out.println(str);
		
		//StringBuffer sb1 = "Hello"; //사용못함
		StringBuffer sb1 = new StringBuffer();
		System.out.println("sb1.length() : " + sb1.length());
		System.out.println("sb1.capacity() : " + sb1.capacity());

		StringBuffer sb = new StringBuffer("Hello Java!!!");
		System.out.println("sb : " + sb);
		System.out.println("sb.toString() : " + sb.toString());
		
		String sbValue = sb.toString();
		System.out.println("sbValue : " + sbValue);
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());

		System.out.println("--- append() ---");
		sb.append(" 반갑습니다").append("~~~~");
		System.out.println(sb.toString());
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		System.out.println("sb.reverse() : "+ sb.reverse());
		System.out.println(sb);
		
		//                        삭제          입력(끼워넣기), 수정
		System.out.println("=== delete(), insert(), replace() ===");
		//Hello Java!!! 반갑습니다~~~~
		System.out.println("sb.delete(0, 6) : " + sb.delete(0, 6));
		System.out.println(sb);
		
		sb.insert(0, "Hello ");
		System.out.println("sb.insert(0, \"Hello \") 샐행후 : " + sb);
		
		sb.replace(0, 5, "Hi,");
		System.out.println("sb.replace(0, 5, \"Hi,\") 실행 후 : " + sb);
		
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		sb.append(" 자바공부 재밌네요~~ 나만 재밌을까요?");
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		System.out.println("--- trimToSize() ---");
		sb.trimToSize();
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		System.out.println("====================");
		StringBuffer sb2 = new StringBuffer(100);
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		System.out.println("-----");
		
		sb2.append("안녕하세요").append(" 반갑습니다!!");
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println(">> trimToSize() 실행후 ----");
		sb2.trimToSize();
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println(">> append() 실행후 ----");
		sb2.append(" 자바공부중~~~");
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println(">> sb2.setLength(5) 실행후 ---");
		sb2.setLength(5);
		System.out.println(sb2);
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println(">> sb2.setLength(0) 실행후 ---");
		sb2.setLength(0);
		System.out.println("sb2 : -" + sb2 + "-");
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
	}

}


















