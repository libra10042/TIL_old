package com.myproject.dao;

import java.util.ArrayList;

import com.myproject.vo.Doctor;
import com.myproject.vo.Reserve;

public interface DoctorInterface {
	public void doctorReservationRecord();//의사_진료 조회 : 의사번호와 비밀번호를 통해 날자별 예약된 내용을 조회할 수 있어야 한다.
	public ArrayList<Doctor> introduceDoctorInfo(); //병원 의료진 소개 : 병원의 의료진 담당부서, 경력 등을 조회할 수 있어야 한다.
	void doctorReservationRecord(Reserve vo);
}
