package com.mystudy.ex01_exception;

public class Exception_throw {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		// 예외처리 throw : 예외를 발생시킬 때 사용
		// throw 예외객체;
		throw new NullPointerException(); 

		//System.out.println("--- main() 끝 ---");
	}

}
