package com.mystudy.ex02_list_exam;
/* 자바빈(JavaBean) 형태의 클래스
	VO (Value Object) : 값을 저장하기 위한 클래스(객체)
	DTO (Data Transfer Object) : 값을 저장해서 전달하기 위한 클래스(객체)
	예) XxxxVO, XxxxVo, XxxxDTO, XxxxDto 
*/
public class StudentVO {
	//필드 선언 --------------------
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private int tot;
	private double avg;
	
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
//	@Override
//	public String toString() {
//		return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
//				+ ", avg=" + avg + "]";
//	}
	
	
}











