package com.mystudy.bean02;

public class StudentMain {

	public static void main(String[] args) {
		// 홍길동, 100, 90, 80 값 생성자 이용 입력하고
		// get메소드 이용 데이터 확인
		Student stu = new Student("홍길동", 100, 90, 80);
		System.out.println("stu : " + stu);
		stu.setMath(85);
		stu.setEng(95);
		//stu.setAvg(100);
		stu.setKor(950);
		
//		stu.setTot(stu.getKor() + stu.getEng() + stu.getMath());
//		stu.setAvg(stu.getTot() * 100 / 3 / 100.0);
		System.out.println("stu : " + stu);
		
		System.out.println("==========================");
		// 김유신, 99, 88, 77 값  기본생성자 사용 객체(인스턴스) 생성
		// set메소드 사용해서 성적 입력하고, get메소드 사용 입력값 확인

	}

}
