package com.myproject.dao;

import com.myproject.vo.Clients;

public interface CustomerInterface {
	public boolean insertClients(Clients c);//고객등록 [환자등록 시 회원가입 없이(이름, 주민번호, 핸드폰번호)로 등록가능하여야 한다.
	//유저코드 생성 : 환자등록 시 자동으로 유저코드(가입순 번호)가 생성되어야 한다.
	
	
	public void updateClients(); //4. 전화번호 수정 : 전화번호 변경을 대비하여 고객의 정보(전화번호)수정이 가능하여야 한다.
	public void searchClientNumber(String clname, String clpn);//4. 고객번호 찾기 : 고객등록시 입력했던 이름, 주민번호로 고객번호 찾기가 가능하여야 한다.
	
	public boolean existsClient(Clients vo);//기존 고객 : 기존에 방문한 이력이 있는 경우 고객번호를 통해 기존 정보를 확인후 진료 예야깅 가능하여야 한다.
	public void reservation();  //진료 예약 : 진료예약시 진료 가능한 과, 교수, 날짜 등을 부여주어 선택 가능하여야 한다.
	public void searchClientReservation(); //고객_예약 조회 : 발급받은 고객번호를 통해 예약한 내역을 볼 수 있어야 한다.
	public void cancealReservation(); //예약 취소 : 발급받은 고객번호를 통해 예약을 취소할 수 있어야 한다.
	public void reservationRecord(); //진료 기록 : 발급받은 고객번호를 통해 진료받은 내용을 따로 조회 가능하여야 한다.
	
	
	
}
