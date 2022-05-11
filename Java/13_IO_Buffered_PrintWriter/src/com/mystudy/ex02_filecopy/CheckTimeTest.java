package com.mystudy.ex02_filecopy;

public class CheckTimeTest {

	public static void main(String[] args) {
	
		long startTime = System.currentTimeMillis();
		System.out.println("stratTime: " + startTime);
		for (int i = 1; i <= 1000; i++) {
			System.out.println(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("endTime: " + endTime);
		System.out.println("경과시간 : " + (endTime - startTime));

	}

}
