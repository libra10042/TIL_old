package com.mystudy.ex02_extends;

/*(실습) 클래스 상속(extends) 적용해서 클래스 만들기
실습1: Phone 클래스 상속 확장(extends)
WebPhone 클래스 작성
	- Phone 클래스 상속 확장해서 만들기
	- 생성자 정의
		* 폰번호(phoneNo)만 받아서 객체(인스턴스) 생성
		* 타입 값은 "WebPhone타입"으로 작성
	- 기능 : 전화걸고, 받고, 정보보기, 웹검색 
	- 웹검색 기능
		webSearch() : ">> WebPhone - 웹 검색" 문구 화면 출력
*/
class WebPhone extends Phone {
	
	//생성자 --------
	public WebPhone(String phoneNo) {
		super("WebPhone타입", phoneNo);
	}
	public WebPhone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	//웹검색기능
	public void webSearch() {
		System.out.println(">> WebPhone - 웹 검색");
	}
}









