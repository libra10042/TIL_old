package com.mystudy.wrapper;

public class Ex03_max_value_exam {

	public static void main(String[] args) {
		// 숫자 3개 중 가장 큰 수를 구하시오
		int a = 40;
		int b = 1000;
		int c = 9999;
		
		//if문 사용
		if (a > b) { //a가 큰 경우
			if (a > c) {//a가 큰 경우
				System.out.println("최대값 : " + a);
			} else {//c가 큰 경우
				System.out.println("최대값 : " + c);
			}
		} else if (b > c) {
			System.out.println("최대값 : " + b);
		} else {
			System.out.println("최대값 : " + c);
		}
		
		System.out.println("==== 최대값 패턴 사용 ===");
		int max = Integer.MIN_VALUE;
		if (a > max) {
			max = a;
		}
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		System.out.println("최대값 : " + max);

	}

}








