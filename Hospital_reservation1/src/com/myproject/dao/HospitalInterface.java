package com.myproject.dao;

import com.myproject.vo.Clients;

public interface HospitalInterface {
	public boolean insertClients(Clients c);//����� [ȯ�ڵ�� �� ȸ������ ����(�̸�, �ֹι�ȣ, �ڵ�����ȣ)�� ��ϰ����Ͽ��� �Ѵ�.
	//�����ڵ� ���� : ȯ�ڵ�� �� �ڵ����� �����ڵ�(���Լ� ��ȣ)�� �����Ǿ�� �Ѵ�.
	public void updateClients(); //��ȭ��ȣ ���� : ��ȭ��ȣ ������ ����Ͽ� ���� ����(��ȭ��ȣ)������ �����Ͽ��� �Ѵ�.
	public void searchClientNumber(String clname, String clpn);//����ȣ ã�� : ����Ͻ� �Է��ߴ� �̸�, �ֹι�ȣ�� ����ȣ ã�Ⱑ �����Ͽ��� �Ѵ�.
	public void newClient(); //�ű� �� : ù �湮�� ���ῡ �ʿ��� �������� �Է��Ͽ� ����� �� ���� ������ �����Ͽ��� �Ѵ�.
	public void existsClient();//���� �� : ������ �湮�� �̷��� �ִ� ��� ����ȣ�� ���� ���� ������ Ȯ���� ���� ���߱� �����Ͽ��� �Ѵ�.
	public void reservation();  //���� ���� : ���Ό��� ���� ������ ��, ����, ��¥ ���� �ο��־� ���� �����Ͽ��� �Ѵ�.
	public void searchClientReservation(); //��_���� ��ȸ : �߱޹��� ����ȣ�� ���� ������ ������ �� �� �־�� �Ѵ�.
	public void cancealReservation(); //���� ��� : �߱޹��� ����ȣ�� ���� ������ ����� �� �־�� �Ѵ�.
	public void reservationRecord(); //���� ��� : �߱޹��� ����ȣ�� ���� ������� ������ ���� ��ȸ �����Ͽ��� �Ѵ�.
	public void doctorReservationRecord();//�ǻ�_���� ��ȸ : �ǻ��ȣ�� ��й�ȣ�� ���� ���ں� ����� ������ ��ȸ�� �� �־�� �Ѵ�.
	public void introduceDoctorInfo(); //���� �Ƿ��� �Ұ� : ������ �Ƿ��� ���μ�, ��� ���� ��ȸ�� �� �־�� �Ѵ�.
	
	
}
