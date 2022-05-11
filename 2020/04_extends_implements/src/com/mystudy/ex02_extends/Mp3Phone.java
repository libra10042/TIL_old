package com.mystudy.ex02_extends;

// Phone 클래스를 상속받아(extends - 확장해서) Mp3Phone 만들기
class Mp3Phone extends Phone {

	public Mp3Phone(String phoneNo) {
		/*
		 * 명시적으로 부모클래스의 생성자 호출을 하지 않는 경우
		 * 컴파일러가 super(); 코드를 생성자의 가장 첫번째 줄에 작성해서 컴파일 진행
		 */
		//super(); //super() : 부모클래스의 기본생성자 자동호출 코드가 삽입됨
		
		// super : 부모클래스, super() : 부모클래스의 생성자
		super("Mp3Phone타입", phoneNo);
	}
	
	//전화걸기 기능 메소드 작성
	public void playMusic() {
		System.out.println(">> Mp3Phone - 음악플레이");
	}


}









