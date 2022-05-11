package com.mystudy.ex04_interface2;

//전화걸기, 전화받기, 문자보내기, 문자받기, 전화정보확인 : Phone 기능
//음악플레이 : Mp3Phone 고유기능
//웹검색 기능까지 정의

/* 인터페이스 끼리는 여러개를 상속확장(extends)해서 사용할 수 있음
 */
public interface I_WebPhone extends I_Phone, I_Mp3Phone {
	// I_Phone 정의된 메소드 사용 가능(상속확장 사용 extends)
	
	// I_Mp3Phone 정의된 메소드 사용 가능(상속확장 사용 extends)
	
	//웹 검색 기능
	void webSearch();
}













