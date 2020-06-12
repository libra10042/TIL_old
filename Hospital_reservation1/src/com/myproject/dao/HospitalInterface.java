package com.myproject.dao;

import com.myproject.vo.Customer;

public interface HospitalInterface {
	public void inserCustomer(Customer c);//고객등록 [환자등록 시 회원가입 없이(이름, 주민번호, 핸드폰번호)로 등록가능하여야 한다.
	//유저코드 생성 : 환자등록 시 자동으로 유저코드(가입순 번호)가 생성되어야 한다.
	public void updateClients(); //전화번호 수정 : 전화번호 변경을 대비하여 고객의 정보(전화번호)수정이 가능하여야 한다.
	public void searchCustomer(String clname, String clpn);//고객번호 찾기 : 고객등록시 입력했던 이름, 주민번호로 고객번호 찾기가 가능하여야 한다.
	public void newCustomer(); //신규 고객 : 첫 방문시 진료에 필요한 고객정보를 입력하여 고객등록 및 진료 예약이 가능하여야 한다.
	public void existsCustomer();//기존 고객 : 기존에 방문한 이력이 있는 경우 고객번호를 통해 기존 정보를 확인후 진료 예야깅 가능하여야 한다.
	public void   //진료 예약 : 진료예약시 진료 가능한 과, 교수, 날짜 등을 부여주어 선택 가능하여야 한다.
	//고객_예약 조회 : 발급받은 고객번호를 통해 예약한 내역을 볼 수 있어야 한다.
	//예약 취소 : 발급받은 고객번호를 통해 예약을 취소할 수 있어야 한다.
	//진료 기록 : 발급받은 고객번호를 통해 진료받은 내용을 따로 조회 가능하여야 한다.
	//의사_진료 조회 : 의사번호와 비밀번호를 통해 날자별 예약된 내용을 조회할 수 있어야 한다.
	//병원 의료진 소개 : 병원의 의료진 담당부서, 경력 등을 조회할 수 있어야 한다.
	
	
}
