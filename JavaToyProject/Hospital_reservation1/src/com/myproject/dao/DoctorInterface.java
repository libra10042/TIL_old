package com.myproject.dao;

import java.util.ArrayList;

import com.myproject.vo.Doctor;
import com.myproject.vo.Reserve;

public interface DoctorInterface {
	public void doctorReservationRecord();//�ǻ�_���� ��ȸ : �ǻ��ȣ�� ��й�ȣ�� ���� ���ں� ����� ������ ��ȸ�� �� �־�� �Ѵ�.
	public ArrayList<Doctor> introduceDoctorInfo(); //���� �Ƿ��� �Ұ� : ������ �Ƿ��� ���μ�, ��� ���� ��ȸ�� �� �־�� �Ѵ�.
	void doctorReservationRecord(Reserve vo);
}
