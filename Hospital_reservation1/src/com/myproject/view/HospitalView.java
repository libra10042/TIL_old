package com.myproject.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.myproject.dao.CustomerDao;
import com.myproject.vo.Clients;
import com.myproject.vo.Doctor;

public class HospitalView {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private int choice; 
	private String clname, clpn, clphone, doname, password, info_doctor, partname; 
	private String sympton;
	private int renumber, clnumber, donumber, partnumber;
	private Date schedule;
	private CustomerDao hd = new CustomerDao(); 
	
	
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
		System.out.println("����������������������������");
		System.out.println("�� [����ó�Դϴ�] ��");
		System.out.println("��1.ó���湮           ��");
		System.out.println("��2.�����湮           ��");
		System.out.println("����������������������������");
		System.out.print(">>");
		choice = sc.nextInt(); 
		switch(choice) {
		case 1:
			// ����, ����ȣ, �ֹε�Ϲ�ȣ, ��ȭ��ȣ, ���� �Է� ��� �� �Է� �ߴٸ� �����Է� â ���
			insertClients();
			
			break;
			
		case 2:
			existsClients();
			
			break;
		}
	}
	// 1-1. ó���湮 �� ���. 
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
			
			careCheck(); 
			
		}else {
			System.out.println("**Error ����� �����Դϴ�.");
			return flag; 
			
		}
		return flag; 
		
	}
	// 1-2.���� �湮 �� 
	public boolean existsClients() {
		boolean flag = false; 
		System.out.print("������ ��ȣ�� �Է����ּ��� : ");
		clnumber = sc.nextInt();
		
		Clients s = new Clients(clnumber);
		
		if(hd.existsClient(s)) {
			flag = true;
			System.out.println("[[���Ό���� �����մϴ�.]]" );
			System.out.print("������ �Է����ּ��� : ");
			sympton = scLine.nextLine(); 
			
			careCheck();
			
		}else {
			System.out.println("** �������� �ʴ� ȸ���Դϴ�.");
		}
		return false; 
		
		
	}
	
	
	
	
	// �� ��ȣ�� ���� ������ �����ϴ�.
	public void searchClients() {
		//ȯ�ڹ�ȣ �Է�
		System.out.println("ȯ�� ��ȣ�� �Է��ϼ��� :");
		clnumber= sc.nextInt(); 
		
		Clients c = new Clients(clnumber);
		
		
		
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
		choice  = sc.nextInt(); 
		switch(choice) {
		case 1: 
			
			
			break;
			
		case 2:
			
			break;
		case 3: 
		}
	}
	
	

	
	
	//������ȸ �� ���� ���
	public void DoctorInfo() {
		
	}
	
	//�Ƿ��� �Ұ�
	public void DoctorIntroduce() {
		System.out.println("�Ƿ��� �Ұ�");
		System.out.printf("%-20s%-25s%-20s%-25s%-20s%n", "��ȣ", "�̸�", "����", "�з�", "���" );
		System.out.println("======================================================");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10001", "������", "����", "����� ����", "�����������10�� ���");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10002", "�����", "�ܰ�", "���������", "������15����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10003", "�����", "�Ҿư�", "������ ����", "����������� 5����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10004", "�����", "�����ܰ�", "�Ѿ������", "�Ѿ�뺴�� 15����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10005", "�Ŵ���", "�Ȱ�", "����� ����", "������ 1����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10006", "�迵��", "����", "�Ǳ��� ����", "�Ǵ뺴�� 5����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10007", "������", "�ܰ�", "����� ����", "������ 10����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10008", "���켺", "�Ҿư�", "������ ����", "�� ���� 30����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10009", "�ձ⿵", "�����ܰ�", "�Ѿ�� ����", "������ 10����");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10010", "��ȫ��", "�Ȱ�", "�Ǳ��� ����", "�Ǵ뺴��5�� ���");
	
	
	}
	
	
	
	//������
	public void CustomerInfo() {
		System.out.println("��������������������������������������");
		System.out.println("�����Ͻô� �޴��� �����ϼ��䦢");
		System.out.println("��1. �������ȭ��ȣ ���榢");
		System.out.println("��2. ����ȣ �н�            ��");
		System.out.println("��������������������������������������");
		System.out.print(">>");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			updateClients();
			break;
			
		case 2: 
			searchClientNumber(); 
			break;
		}
		
		
	}
	
	// �� ���� ����. (�޴��� ��ȣ)
	public boolean updateClients() {
		boolean flag = false;  
		
		System.out.println("[ �� ��� ��ȭ��ȣ�� ���� �޴�.]");
		System.out.print("�� �̸��Է� :");
		clname = scLine.nextLine();
		System.out.print("�� �ֹι�ȣ �Է� : ");
		clpn = scLine.nextLine(); 
		
		Clients vo = new Clients(clname, clpn);
		
		if(hd.checkClientNumber(vo)) {
			flag = true;
			System.out.print("������ ���� �ڵ��� ��ȣ�� �Է� : ");
			clphone = scLine.nextLine(); 
			Clients vo2 = new Clients(clname, clpn, clphone);
			if(hd.updateClients(vo2)) {
				System.out.println("������ ������ ���������� �����Ǿ����ϴ�.");
			}else {
				System.out.println("** �����߻�. ");
			}
			
			
		}
		return false; 
	}

	public boolean searchClientNumber() {
		boolean flag = false; 
		
		System.out.println("[ �� ��ȣ ã�� ]");
		System.out.print("�� �ڵ��� ��ȣ �Է� : ");
		clphone = scLine.nextLine(); 
		 
		Clients vo = new Clients(clphone);
		if(hd.searchClientNumber(vo)) {
			flag = true; 
		}else {
			System.out.println("** �������� �ʴ� �ڵ��� ��ȣ�Դϴ�.");
		}
		
		return false; 
	}
	
	
}
