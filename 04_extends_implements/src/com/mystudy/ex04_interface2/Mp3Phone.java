package com.mystudy.ex04_interface2;

//전화걸기, 전화받기, 문자보내기, 문자받기, 전화정보확인 : Phone 기능
//음악플레이 : Mp3Phone 고유기능
//(실습) Phone 클래스 상속 확장해서 사용하고 I_Mp3Phone 인터페이스를 구현해서 만들기
public class Mp3Phone extends Phone 
	                  implements I_Mp3Phone {

	public Mp3Phone(String phoneNo) {
		super("Mp3Phone타입", phoneNo);
	}
	public Mp3Phone(String type, String phoneNo) {
		super(type, phoneNo);
	}
	
	@Override
	public void playMusic() {
		System.out.println(">>Mp3Phone 음악플레이~~");
	}
}

















