package com.mystudy.ex01_class;

class Mp3Phone {
	private String type;
	private String phoneNo;
	
	public Mp3Phone(String phoneNo) {
		type = "Mp3Phone타입";
		this.phoneNo = phoneNo;
	}
	public Mp3Phone(String type, String phoneNo) {
		super();
		this.type = type;
		this.phoneNo = phoneNo;
	}
	
	//메소드 ------------
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	//전화걸기
	public void call() {
		System.out.println(">> 전화걸기");
	}
	//전화받기
	public void receiveCall() {
		System.out.println(">> 전화받기");
	}
	//전화정보보기
	public void view() {
		System.out.println("타입: "+ type + ", 번호: " + phoneNo);
	}
	
	//음악플레이 기능 -------------
	public void playMusic() {
		System.out.println(">> 음악 플레이~~");
	}
	
}




















