package com.mystudy.ex03_sungjuk;

//내가 사용할 예외(Exception) 만들기
// SungjukProcessException 예외 클래스를 상속 확장해서 만들기(그룹핑해서 예외 관리)
public class JumsuOutOfRangeException extends SungjukProcessException {
	public JumsuOutOfRangeException() {
		super("점수범위(0~100)를 벗어난 값입니다.");
	}
}
