package com.myproject.view;

import java.util.Scanner;

import com.myproject.dao.InventoryDAO;
import com.myproject.vo.Admin;
import com.myproject.vo.Member;

public class InventoryView {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean flag = true;
	private int choice;
	private String no, name, pw, id; // ����� ����
	private String adminName, adminId, adminPw, adminPhone, adminAddress; // ������ ����

	private InventoryDAO iven = new InventoryDAO();

	public InventoryView() {
		while (true) {

			Home();

			choice = sc.nextInt();
			switch (choice) {
			// �α��� �޴�
			case 1:
				if(loginMember()) {
					loginMenu();
				}else {
					System.out.println("�α��� ���� �ϼ̽��ϴ�.");
					continue;
				}
				
				break;
			case 2:
				insertMember();
				break;

			case 3:
				adminMenu();
				break;

			case 4:
				flag = false;
				System.out.println(">>������ ����Ǿ����ϴ�.");
				break;

			}

		}

	}

	// Ȩ
	public void Home() {
		System.out.println("��������������������������������������������");
		System.out.println("�� ������� ���������α׷�      ��");
		System.out.println("��1. �α���                             ��");
		System.out.println("��2. ȸ������                          ��");
		System.out.println("��3. ������                             �� ");
		System.out.println("��4. ����                                ��");
		System.out.println("�������������������������������������������� ");
		System.out.print(">> ");
	}

	// �α��� �ϱ�.
	public boolean loginMember() {
		boolean result  =true; 
		System.out.println("�α��� ���ּ���.");
		System.out.println("ID: ");
		id = scLine.nextLine();
		System.out.println("PW: ");
		pw = scLine.nextLine();
		System.out.println();
		
		Member m = new Member(id,pw);
		if(iven.loginMember(m)) {
			System.out.println(id + "�� ȯ���մϴ�.");
			return result;
		}else{
			System.out.println(">> �α��� �����ϼ̽��ϴ�.");
			result = false;
		}
		return result;
	}

	// ȸ������ ������
	public void insertMember() {
		System.out.print("ȸ�� �Ϸù�ȣ : ");
		no = scLine.nextLine();
		System.out.print("�̸� �Է� : ");
		name = scLine.nextLine();
		System.out.print("���̵� �Է� :");
		id = scLine.nextLine();
		System.out.print("�н������Է�:");
		pw = scLine.nextLine();

		Member m1 = new Member(no, name, id, pw);
		if(iven.insertMember(m1)) {
			System.out.println("ȸ������ �Ϸ�Ǿ����ϴ�.");
		}else {
			System.out.println("** ȸ������ �����Դϴ�.");
		}
	}

	//����� �α��� �޴�
	//�α��� �� ó���� ���� ���� ������
		public void loginMenu() {
			System.out.println("1. �����ϱ�(��)");
			System.out.println("2. �Ǹŵ��(�Ǹ���) ");
			System.out.println("0. ���� �޴���");
			System.out.println(">>");
			choice = sc.nextInt();
			while(true) {
				switch(choice) {
				case 1: 
					break;
				case 2:
					break;
				case 0: 
					loginMember(); //�ٽ� �α��� ȭ������
					break;
				}
			}
		}

	public void buyMenu() {
		System.out.println(" << �����ڸ޴�>> ");
		System.out.println("1. ��ǰ ��ü ����");
		System.out.println("2. ��ǰ ���� �����ϱ�");
		System.out.println("0. ���� �޴���");
		System.out.print(">>");
		choice = sc.nextInt();
	}

	public void sellMenu() {
		System.out.println(" << �Ǹ��ڸ޴�>>");
		System.out.println("1. ��ǰ���");  
		System.out.println("2. ��ǰ ��ü ����"); 
		System.out.println("3. �Ǹ����� ��� ");
		System.out.println("4. �Ǹ����� ��ü����");
		System.out.println("5. �Ǹ����� ����");
		System.out.println("6. �Ǹ����� ����");
		System.out.println("0. ���� �޴� ");
		System.out.print(">>");
		choice = sc.nextInt();
	}

	//

	// ������ �α��� ȸ������ �޴�.
	public void adminMenu() {
		System.out.println("������������������������������������");
		System.out.println("�� ������ �޴�                  ��");
		System.out.println("��1. ������ �α���          ��");
		System.out.println("��2. ������ ȸ������       ��");
		System.out.println("��3. �����޴�                 �� ");
		System.out.println("������������������������������������ ");
		System.out.print(">> ");
		choice = sc.nextInt();

		while (flag) {
			switch (choice) {
			case 1:
				if (adminLogin()) {
					AdminPage();
				} else {
					adminMenu();
				}
				break;
			case 2:
				insertAdmin();
				break;

			case 3:
				flag = false;
				break;
			}
		}

	}

	// ������ ȸ������
	public void insertAdmin() {
		System.out.println("<<������ ȸ������ �ϱ�>>");
		System.out.print("������ �̸� : ");
		adminName = scLine.nextLine();
		System.out.print("������ ���̵� : ");
		adminId = scLine.nextLine();
		System.out.print("������ �н����� : ");
		adminPw = scLine.nextLine();
		System.out.print("������ �ڵ�����ȣ : ");
		adminPhone = scLine.nextLine();
		System.out.print("������ �ּ� : ");
		adminAddress = scLine.nextLine();
		System.out.print("ȸ�� �Ϸù�ȣ : ");
		no = scLine.nextLine();

		Admin admin = new Admin(adminName, adminId, adminPw, adminPhone, adminAddress, no);
		if (iven.insertAdmin(admin) == 1) {
			System.out.println("������ ȸ�� ���� �Ϸ�!!");
		} else {
			System.out.println("������ ȸ������ ����!");
		}

	}

	// ������ �α���
	public boolean adminLogin() {
		boolean result = true;
		System.out.println("[[������ �α���]]");
		System.out.print("������ ���̵� : ");
		adminId = scLine.nextLine();
		System.out.print("������ ��й�ȣ : ");
		adminPw = scLine.nextLine();

		Admin admin = new Admin(adminId, adminPw);
		if (iven.loginAdmin(admin)) {
			System.out.println(adminId + "�����ڴԲ��� �α��� �ϼ̽��ϴ�.");
			AdminPage();
			choice = sc.nextInt();
			System.out.println(">>");
			switch(choice) {
			case 1: 
				iven.selectAllMember();
				break;
				
			case 2: 
				
				break;
				
				
			case 3: 
				break;
				
			case 4: 
				
				break;
				
			case 0:
				
				break;
			}
			return result;
		} else {
			System.out.println("** �α��� �����ϼ̽��ϴ�.");
			adminMenu();
			result = false;
		}
		return result;
	}

	//������ �α��ε� ������ 
	public void AdminPage() {
		
		System.out.println("����������������������������������������������������");
		System.out.println("��   [[������ ȸ������������]]   ��");
		System.out.println("��1. ������ ȸ�� ��ü ���� Ȯ���ϱ�    ��");
		System.out.println("��2. ȸ������ ����                            ��");
		System.out.println("��3. ȸ������ ����                            ��");
		System.out.println("��4. �Ǹ��� ������ȸ                         ��");
		System.out.println("��0. ����                                         ��");
		System.out.println("����������������������������������������������������");
		System.out.print(">>");
		
	}
	
	

}
