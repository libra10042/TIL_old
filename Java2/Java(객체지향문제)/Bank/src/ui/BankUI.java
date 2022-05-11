package ui;

import java.util.Scanner;

import service.BankService;
import vo.Account;
import vo.Client;
import vo.DepositAccount;
import vo.MinusAccount;

public class BankUI {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private BankService bs = new BankService();
	private int choice, balance;
	private String name, ssn, address, phoneNum, AccountNum, from, to;
	private boolean flag = true;
	
	
	public BankUI() {
		while(flag) {
			menu();
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				if(bs.insertClient(makeClient())){
					System.out.println("�Ϸ�");
				}else {
					System.out.println("***����");
				}
				
				break;
				
			case 2: 
				System.out.println("�ֹι�ȣ �Է� : ");
				ssn = scLine.nextLine();
				if(bs.registerAccount(ssn, makeAccount())) {
					System.out.println("�Ϸ�");
				}else {
					System.out.println("***����");
				}
				
				break;
				
			case 3: 
				if(depositAccNum()){
					System.out.println("�Ϸ�");
				}else {
					System.out.println("***����");
				}
				break;
				
			case 4: 
				if(depositAccNum()) {
					System.out.println("�Ϸ�");
				}else {
					System.out.println("***����");
				}
				break;
				
			case 5:
				if(withdrawAccNum()) {
					System.out.println("�Ϸ�");
				}else {
					System.out.println("***����");
				}
				break;
				
			case 6: 
				bs.printAllClient();
				break;
			
			case 7:
				System.out.println("�ֹι�ȣ �Է� : ");
				ssn = scLine.nextLine();
				bs.printAllAccount(ssn);
				break;
			}
			
		}
		
	}
	

	public void menu() {
		System.out.println("=======================");
		System.out.println("1.�����");
		System.out.println("2.���µ��");
		System.out.println("3.���¿��Ա�");
		System.out.println("4.���¿������");
		System.out.println("5.�۱�");
		System.out.println("6.������ ��� ���");
		System.out.println("7.�������� �˻�(�ֹι�ȣ�Է�)");
		System.out.println("=======================");
	}
	
	
	public Client makeClient() {
		System.out.println("���̸� �Է� :");
		name = scLine.nextLine();
		System.out.println("�ֹι�ȣ �Է� :");
		ssn = scLine.nextLine();
		System.out.println("�ּ� �Է� : ");
		address = scLine.nextLine();
		System.out.println("�ڵ��� ��ȣ �Է� : ");
		phoneNum = scLine.nextLine();
		
		return new Client(name, ssn, address, phoneNum);	
	}
	
	
	
	public Account makeAccount() {
		System.out.println("���¹�ȣ �Է� : ");
		AccountNum = scLine.nextLine();
		System.out.println("�ܰ� �Է� : ");
		balance = sc.nextInt();
		
		System.out.println("---------------");
		System.out.println("���� ���� : ");
		System.out.println("1. ���� ����");
		System.out.println("2. ���̳ʽ� ����");
		choice = sc.nextInt();
		
		if(choice ==1) {
			return new DepositAccount(AccountNum, balance);
		}else {
			return new MinusAccount(AccountNum, balance);
		}
	}

	
	public boolean depositAccNum() {
		System.out.println("���¹�ȣ �Է� : ");
		AccountNum = scLine.nextLine();
		System.out.println("������ �ݾ� �Է� : ");
		balance = sc.nextInt();
		
		return bs.deposit(AccountNum, balance);
	}
	
	public boolean withdrawAccNum() {
		System.out.println("���¹�ȣ �Է� : ");
		AccountNum = scLine.nextLine();
		System.out.println("����� �ݾ� �Է� : ");
		balance = sc.nextInt();
		
		return bs.withdrawal(AccountNum, balance);
	}
		
	
	public boolean transferAcc() {
		System.out.println("�۱��� ���� ����");
		from = scLine.nextLine();
		System.out.println("����� ���� �Է�");
		balance = sc.nextInt();
		System.out.println("�����Ǻ� ���¹�ȣ ����");
		to = scLine.nextLine();
		
		
		return bs.transfer(from, to, balance);
	}

	
	
}
