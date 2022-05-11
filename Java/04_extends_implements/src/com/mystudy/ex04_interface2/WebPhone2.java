package com.mystudy.ex04_interface2;

public class WebPhone2 extends Mp3Phone 
		implements I_WebPhone {

	public WebPhone2(String phoneNo) {
		super("WebPhone", phoneNo);
	}
	public WebPhone2(String type, String phoneNo) {
		super(type, phoneNo);
	}

	@Override
	public void webSearch() {
		// TODO Auto-generated method stub
		
	}

}





