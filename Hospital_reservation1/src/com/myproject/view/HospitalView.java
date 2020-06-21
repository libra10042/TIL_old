package com.myproject.view;

import java.util.Date;
import java.util.Scanner;

import com.myproject.dao.HospitalDao;
import com.myproject.vo.Clients;

public class HospitalView {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private int choice; 
	private String clname, clpn, clphone, doname, password, info_doctor, partname; 
	private String sympton;
	private int renumber, clnumber, donumber, partnumber;
	private Date schedule;
	private HospitalDao hd = new HospitalDao(); 
	
	
	private boolean flag = true;
	
	public HospitalView() {
		
		while(flag) {
			
			Home();
			choice = sc.nextInt(); 
			switch(choice) {
			case 1: 
				visitView(); 
				break;
				
			case 2: 
				reserveAndCancel(); 
				break;
				
			case 3: 
				DoctorIntroduce();
				break;
				
			case 4:
				CustomerInfo();
				break;
			
			
			
			
			
			}
			
		}
	
	
	}
	
	
	
	//---------------------------------------1. ���� ���� -------------------------------------------
	public void Home() {
		System.out.println("��������������������������������������������");
		System.out.println("��1. ���Ό���ϱ�                    ��");
		System.out.println("��2. ������ȸ �� ���� ���        ��" );
		System.out.println("��3. �Ƿ��� �Ұ�                      ��");
		System.out.println("��4. ������                          ��");
		System.out.println("��5. ����                                ��");
		System.out.println("��������������������������������������������");
		System.out.print(">>");
	}
	
	
	
	
	
	//1-1. ���Ό��   
	public void visitView() {
		System.out.println("��������������������������");
		System.out.println("�� [����ó�Դϴ�]��");
		System.out.println("��1.ó���湮        ��");
		System.out.println("��2.�����湮        ��");
		System.out.println("��������������������������");
		System.out.println(">>");
		choice = sc.nextInt(); 
		switch(choice) {
		case 1:
			// ����, ����ȣ, �ֹε�Ϲ�ȣ, ��ȭ��ȣ, ���� �Է� ��� �� �Է� �ߴٸ� �����Է� â ���
			insertClients(); 
			
			
			
			
			break;
			
		case 2:
			//ȯ�ڹ�ȣ �Է�
			System.out.println("ȯ�� ��ȣ�� �Է��ϼ��� :");
			
			
			break;
		}
	}
	// 1. ó���湮 �� ���. 
	public boolean insertClients() {
		flag = false; 
		System.out.println("���� ������ ���� �ʼ������� �Է��մϴ�.");
		System.out.print("�� �̸� �Է� : ");
		clname = scLine.nextLine(); 
		System.out.print("�� �ֹι�ȣ �Է� : ");
		clpn = scLine.nextLine(); 
		System.out.print("�� ��ȭ��ȣ �Է� : ");
		clphone = scLine.nextLine(); 
		
		Clients s = new Clients(clname, clpn, clphone);
		
		if(hd.insertClients(s)) {
			flag = true;
			System.out.println(">>�� ����� �Ϸ�Ǿ����ϴ�.");
			System.out.print("������ �Է����ּ��� : ");
			sympton = scLine.nextLine(); 
			
			
		}else {
			System.out.println("**Error ����� �����Դϴ�.");
			return flag; 
			
		}
		return flag; 
		
	}
	
	
	
	
	//1-2. ���� ����
	public void careCheck() {
		System.out.println("-----����-----");
		System.out.println("1. ����,    2. �ܰ�,    3.�Ҿư�,    4.�����ܰ�,    5.�Ȱ�");
		System.out.print(">>");
		choice = sc.nextInt(); 
		scLine.nextLine(); 
		switch(choice) {
		// ���� �����ϸ� ������ ���ϰ� ��ô� �����Ե��� ������ �� �ִ�. ���� ���ڸ� �����Ѵ�. ���೯¥�� �����ϸ� �����û�� �Ϸ�ȴ�. 
		case 1:
			
			break;
			
		case 2:
			break;
		
		}
		
	}
	
	
	public void reserveAndCancel() {
		System.out.println("��������������������������������������");
		System.out.println("���α��� ������ �������ּ��䦢");
		System.out.println("��1. ��                         ��");
		System.out.println("��2. ����                         ��");
		System.out.println("��3. ��������                   ��");
		System.out.println("��������������������������������������");
		System.out.print(">>");
		scLine.nextLine(); 
	}
	
	
	
	
	//������ȸ �� ���� ���
	public void DoctorInfo() {
		
	}
	
	//�Ƿ��� �Ұ�
	public void DoctorIntroduce() {
		System.out.println("�Ƿ��� �Ұ�");
		System.out.printf("%-20s%-25s%-20s%-25s%-20s%n", "��ȣ", "�̸�", "����", "�з�", "���" );
		System.out.println("======================================================");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "1", "������", "����", "����� ����", "�����������10�� ���");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "2", "�����", "�ܰ�", "���������", "������15����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "3", "�����", "�Ҿư�", "������ ����", "����������� 5����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "4", "�����", "�����ܰ�", "�Ѿ������", "�Ѿ�뺴�� 15����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "5", "�Ŵ���", "�Ȱ�", "����� ����", "������ 1����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "6", "�迵��", "����", "�Ǳ��� ����", "�Ǵ뺴�� 5����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "7", "������", "�ܰ�", "����� ����", "������ 10����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "8", "���켺", "�Ҿư�", "������ ����", "�� ���� 30����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "9", "�ձ⿵", "�����ܰ�", "�Ѿ�� ����", "������ 10����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10", "��ȫ��", "�Ȱ�", "�Ǳ��� ����", "�Ǵ뺴��5�� ���");
		
	
	}
	
	
	
	//������
	public void CustomerInfo() {
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("1. �������ȭ��ȣ ����");
		System.out.println("2. ����ȣ �н�");
		
	}
	
	


	
	
}
