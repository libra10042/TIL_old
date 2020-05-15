package com.mystudy.ex05_interface3;

public class PhoneTest {

	public static void main(String[] args) {
		System.out.println(I_Phone.SUCCESS_CALL);
		System.out.println(I_Phone.FAIL_CALL);
		I_Phone.staticMethod();
		
		Phone ph = new Phone();
		
	}

}
