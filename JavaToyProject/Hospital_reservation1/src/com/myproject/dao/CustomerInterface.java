package com.myproject.dao;

import com.myproject.vo.Clients;

public interface CustomerInterface {
	public boolean insertClients(Clients c);//����� [ȯ�ڵ�� �� ȸ������ ����(�̸�, �ֹι�ȣ, �ڵ�����ȣ)�� ��ϰ����Ͽ��� �Ѵ�.
	//�����ڵ� ���� : ȯ�ڵ�� �� �ڵ����� �����ڵ�(���Լ� ��ȣ)�� �����Ǿ�� �Ѵ�.
	
	
	public void updateClients(); //4. ��ȭ��ȣ ���� : ��ȭ��ȣ ������ ����Ͽ� ���� ����(��ȭ��ȣ)������ �����Ͽ��� �Ѵ�.
	public void searchClientNumber(String clname, String clpn);//4. ����ȣ ã�� : ����Ͻ� �Է��ߴ� �̸�, �ֹι�ȣ�� ����ȣ ã�Ⱑ �����Ͽ��� �Ѵ�.
	
	public boolean existsClient(Clients vo);//���� �� : ������ �湮�� �̷��� �ִ� ��� ����ȣ�� ���� ���� ������ Ȯ���� ���� ���߱� �����Ͽ��� �Ѵ�.
	public void reservation();  //���� ���� : ���Ό��� ���� ������ ��, ����, ��¥ ���� �ο��־� ���� �����Ͽ��� �Ѵ�.
	public void searchClientReservation(); //��_���� ��ȸ : �߱޹��� ����ȣ�� ���� ������ ������ �� �� �־�� �Ѵ�.
	public void cancealReservation(); //���� ��� : �߱޹��� ����ȣ�� ���� ������ ����� �� �־�� �Ѵ�.
	public void reservationRecord(); //���� ��� : �߱޹��� ����ȣ�� ���� ������� ������ ���� ��ȸ �����Ͽ��� �Ѵ�.
	
	
	
}
