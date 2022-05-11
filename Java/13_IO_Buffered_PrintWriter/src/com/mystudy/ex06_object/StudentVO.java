package com.mystudy.ex06_object;

import java.io.Serializable;

/*
Serializable 인터페이스 : 데이터 전송을 위한 Object를 만들때
	Serializable 인터페이스를 구현해 주어야 전송할 수 있는 데이터 타입이 됨
전송에서 제외되는 데이터
	- transient 설정된 필드
	- static 필드
*/
public class StudentVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//필드 선언 --------------------
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private int tot;
	private double avg;
	
	//transient : 데이터 전송시 제외 지정
	transient private String phone; //전화번호
	
	
	//생성자 선언 ---------------------------
	//성명, 국어, 영어, 수학 점수를 입력받는 생성자
	//		총점, 평균 점수 계산 처리까지 구현
	public StudentVO(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		//총점, 평균 점수 계산 처리까지 구현
		computeTotAvg();
	}
	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
	
	//메소드 선언 -------------------------
	/* setter, getter를 작성
	국어, 영어, 수학 점수가 입력되면 총점, 평균 재계산 처리
	국어, 영어, 수학 점수는 0~100까지 값만 입력
	----------------------------------*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		if (kor >= 0 && kor <= 100) {
			this.kor = kor;
			computeTotAvg();
		} else {
			System.out.println("[예외] 국어점수 0~100 아님");
		}
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		if (eng >= 0 && eng <= 100) {
			this.eng = eng;
			computeTotAvg();
		} else {
			System.out.println("[예외] 영어점수 0~100 아님");
		}
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		if (math >= 0 && math <= 100) {
			this.math = math;
			computeTotAvg();
		} else {
			System.out.println("[예외] 수학점수 0~100 아님");
		}
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	
	//데이타 보여주기 메소드 printData() 작성
	//성명, 국어, 영어, 수학, 총점, 평균 값을 화면 출력(간격은 탭간격)
	public void printData() {
		System.out.println(name + "\t" + kor + "\t" + eng
				 + "\t" + math + "\t" + tot + "\t" + avg);
	}
	
	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + ", phone=" + phone + "]";
	}
	//------------------------
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}











