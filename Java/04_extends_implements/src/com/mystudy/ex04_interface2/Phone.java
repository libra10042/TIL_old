package com.mystudy.ex04_interface2;

//(실습)인터페이스(interface) 구현(implements)하는 방식으로 클래스 만들기
// I_Phone 인터페이스 사용
/* 전화기 클래스 만들기
속성 : 타입(type), 전화번호(phoneNo)
기능
- 전화 정보 확인기능(view)
- 전화걸기(call)
- 전화받기(receiveCall)
- 메시지 보내기 : ">> 메시지 보냄" 화면출력
- 메시지 받기 : ">> 메시지 받음" 화면출력
*/
public class Phone implements I_Phone {
	//필드(속성) --------
	private String type; //전화기타입(형태,명칭)
	private String phoneNo; //전화번호
	
	//생성자 --------
	public Phone(String phoneNo) {
		this.type = "Phone 타입";
		this.phoneNo = phoneNo;
	}
	public Phone(String type, String phoneNo) {
		super(); //부모클래스의 기본생성자 호출
		this.type = type;
		this.phoneNo = phoneNo;
	}
	
	//메소드(기능) ------
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	@Override //메소드 재정의(상위클래스, 인터페이스 메소드 재정의)
	public void call() {
		System.out.println(">> Phone 전화걸기~~~~");
	}
	@Override
	public void receiveCall() {
		System.out.println(">> Phone 전화받기");
	}
	@Override
	public void view() {
		System.out.println("Phone - 타입: " + type + ", 번호: " + phoneNo);
	}
	@Override
	public void sendMsg() {
		System.out.println(">> 메시지 보냄");
	}
	@Override
	public void receiveMsg() {
		System.out.println(">> 메시지 받음");
	}

	
	
}













