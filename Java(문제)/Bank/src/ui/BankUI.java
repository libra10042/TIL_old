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
					System.out.println("완료");
				}else {
					System.out.println("***실패");
				}
				
				break;
				
			case 2: 
				System.out.println("주민번호 입력 : ");
				ssn = scLine.nextLine();
				if(bs.registerAccount(ssn, makeAccount())) {
					System.out.println("완료");
				}else {
					System.out.println("***실패");
				}
				
				break;
				
			case 3: 
				if(depositAccNum()){
					System.out.println("완료");
				}else {
					System.out.println("***실패");
				}
				break;
				
			case 4: 
				if(depositAccNum()) {
					System.out.println("완료");
				}else {
					System.out.println("***실패");
				}
				break;
				
			case 5:
				if(withdrawAccNum()) {
					System.out.println("완료");
				}else {
					System.out.println("***실패");
				}
				break;
				
			case 6: 
				bs.printAllClient();
				break;
			
			case 7:
				System.out.println("주민번호 입력 : ");
				ssn = scLine.nextLine();
				bs.printAllAccount(ssn);
				break;
			}
			
		}
		
	}
	

	public void menu() {
		System.out.println("=======================");
		System.out.println("1.고객등록");
		System.out.println("2.계좌등록");
		System.out.println("3.계좌에입금");
		System.out.println("4.계좌에서출금");
		System.out.println("5.송금");
		System.out.println("6.고객정보 모두 출력");
		System.out.println("7.계좌정보 검색(주민번호입력)");
		System.out.println("=======================");
	}
	
	
	public Client makeClient() {
		System.out.println("고객이름 입력 :");
		name = scLine.nextLine();
		System.out.println("주민번호 입력 :");
		ssn = scLine.nextLine();
		System.out.println("주소 입력 : ");
		address = scLine.nextLine();
		System.out.println("핸드폰 번호 입력 : ");
		phoneNum = scLine.nextLine();
		
		return new Client(name, ssn, address, phoneNum);	
	}
	
	
	
	public Account makeAccount() {
		System.out.println("계좌번호 입력 : ");
		AccountNum = scLine.nextLine();
		System.out.println("잔고 입력 : ");
		balance = sc.nextInt();
		
		System.out.println("---------------");
		System.out.println("계좌 종류 : ");
		System.out.println("1. 예금 계좌");
		System.out.println("2. 마이너스 계좌");
		choice = sc.nextInt();
		
		if(choice ==1) {
			return new DepositAccount(AccountNum, balance);
		}else {
			return new MinusAccount(AccountNum, balance);
		}
	}

	
	public boolean depositAccNum() {
		System.out.println("계좌번호 입력 : ");
		AccountNum = scLine.nextLine();
		System.out.println("예금할 금액 입력 : ");
		balance = sc.nextInt();
		
		return bs.deposit(AccountNum, balance);
	}
	
	public boolean withdrawAccNum() {
		System.out.println("계좌번호 입력 : ");
		AccountNum = scLine.nextLine();
		System.out.println("출금할 금액 입력 : ");
		balance = sc.nextInt();
		
		return bs.withdrawal(AccountNum, balance);
	}
		
	
	public boolean transferAcc() {
		System.out.println("송금할 계좌 선택");
		from = scLine.nextLine();
		System.out.println("출금할 계좌 입력");
		balance = sc.nextInt();
		System.out.println("받으실분 계좌번호 선택");
		to = scLine.nextLine();
		
		
		return bs.transfer(from, to, balance);
	}

	
	
}
