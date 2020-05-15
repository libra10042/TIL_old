package com.mystudy.ex04_interface2;

public class WebPhone implements I_WebPhone {
	//필드(속성) --------
	private String type; //전화기타입(형태,명칭)
	private String phoneNo; //전화번호
	
	@Override
	public void call() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveCall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMsg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveMsg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void webSearch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMusic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeNo(String phoneNo) {
		this.phoneNo = phoneNo;
		
	}



	
}
