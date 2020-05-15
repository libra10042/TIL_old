package com.mystudy.bean02;

/* 자바빈(Java Bean) 생성 규칙 
- 멤버변수(property)의 접근제어자는 private
- 멤버변수(property) 마다 get/set 메소드 제공(선택적으로 get만 제공)
- get/set 메소드는 public
- get 메소드는 파라미터 없고, set 메소드는 하나 이상의 파라미터 존재
- 멤버변수(property)가 boolean 타입이면 get 메소드 대신 is 메소드 사용가능
- 외부에서 멤버변수(property) 접근시에는 get/set 메소드를 통해 접근
 */
public class Student extends Object {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private int tot;
	private double avg;
	
	//생성자 만들기 ----------------------
	//생성자1 : 기본생성자
	//생성자2 : name 필드값 받아 저장
	//생성자3 : name, kor, eng, math 필드값 받아 저장
	//--------
	// 마우스우측버튼 > source > Generate ...
	// ctrl + shift + s > Generate ...
	public Student() {
		//super : 부모클래스(super 클래스)를 의미
		//super() : 부모클래스의 기본 생성자 호출
		super();
	}
	public Student(String name) {
		super(); //맨 첫줄에 작성 - 부모클래스의 생성자 호출(생략가능)
		this.name = name;
	}
	public Student(String name, int kor, int eng, int math) {
		//현재 객체의 생성자 호출 : 생성자 재사용
		//this(name); //this 현재객체의 String 타입 파라미터값 받는 생성자
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
	}
	
	public Student(String name, int kor, int eng, int math, 
			int tot, double avg) {
		this(name, kor, eng, math); //현재객체의 생성자 호출 재사용
		this.tot = tot;
		this.avg = avg;
	}
	//set메소드(setter, set property) : 리턴타입 void, 파라미터값 있음
	public void setName(String name) {
		this.name = name;
	}
	public void setKor(int kor) {
		if (kor < 0 || kor > 100) {
			System.out.println("[예외발생] 국어점수(0~100) 범위 아님");
			return;
		}
		this.kor = kor;
		computeTotAvg();
	}
	
	//get메소드(getter, get property) : 리턴값 있음, 파라미터값 없음
	public String getName() {
		return this.name;
	}
	public int getKor() {
		return this.kor;
		
	}

	//(실습) eng, math, tot, avg 필드의 setter 작성
	//(실습) eng, math, tot, avg 필드의 getter 작성
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
		computeTotAvg();
	}
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
		computeTotAvg();
	}
	public int getTot() {
		return tot;
	}
	
	//필요에 따라 setter, getter를 제공하지 않기도 함
//	public void setTot(int tot) {
//		this.tot = tot;
//	}

	public double getAvg() {
		return avg;
	}
	//필요에 따라 setter, getter를 제공하지 않기도 함
//	public void setAvg(double avg) {
//		this.avg = avg;
//	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot + ", avg="
				+ avg + "]";
	}
	
	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
	
}













