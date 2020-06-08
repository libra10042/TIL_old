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
	private String no, name, pw, id; // 사용자 정보
	private String adminName, adminId, adminPw, adminPhone, adminAddress; // 관리자 정보

	private InventoryDAO iven = new InventoryDAO();

	public InventoryView() {
		while (true) {

			Home();

			choice = sc.nextInt();
			switch (choice) {
			// 로그인 메뉴
			case 1:
				if(loginMember()) {
					loginMenu();
				}else {
					System.out.println("로그인 실패 하셨습니다.");
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
				System.out.println(">>업무가 종료되었습니다.");
				break;

			}

		}

	}

	// 홈
	public void Home() {
		System.out.println("┌────────────────────┐");
		System.out.println("│ 수산시장 재고관리프로그램      │");
		System.out.println("│1. 로그인                             │");
		System.out.println("│2. 회원가입                          │");
		System.out.println("│3. 관리자                             │ ");
		System.out.println("│4. 종료                                │");
		System.out.println("└────────────────────┘ ");
		System.out.print(">> ");
	}

	// 로그인 하기.
	public boolean loginMember() {
		boolean result  =true; 
		System.out.println("로그인 해주세요.");
		System.out.println("ID: ");
		id = scLine.nextLine();
		System.out.println("PW: ");
		pw = scLine.nextLine();
		System.out.println();
		
		Member m = new Member(id,pw);
		if(iven.loginMember(m)) {
			System.out.println(id + "님 환영합니다.");
			return result;
		}else{
			System.out.println(">> 로그인 실패하셨습니다.");
			result = false;
		}
		return result;
	}

	// 회원가입 페이지
	public void insertMember() {
		System.out.print("회원 일련번호 : ");
		no = scLine.nextLine();
		System.out.print("이름 입력 : ");
		name = scLine.nextLine();
		System.out.print("아이디 입력 :");
		id = scLine.nextLine();
		System.out.print("패스워드입력:");
		pw = scLine.nextLine();

		Member m1 = new Member(no, name, id, pw);
		if(iven.insertMember(m1)) {
			System.out.println("회원가입 완료되었습니다.");
		}else {
			System.out.println("** 회원가입 실패입니다.");
		}
	}

	//사용자 로그인 메뉴
	//로그인 후 처리할 업무 선택 페이지
		public void loginMenu() {
			System.out.println("1. 구매하기(고객)");
			System.out.println("2. 판매등록(판매자) ");
			System.out.println("0. 이전 메뉴로");
			System.out.println(">>");
			choice = sc.nextInt();
			while(true) {
				switch(choice) {
				case 1: 
					break;
				case 2:
					break;
				case 0: 
					loginMember(); //다시 로그인 화면으로
					break;
				}
			}
		}

	public void buyMenu() {
		System.out.println(" << 구매자메뉴>> ");
		System.out.println("1. 상품 전체 보기");
		System.out.println("2. 상품 선택 구매하기");
		System.out.println("0. 이전 메뉴로");
		System.out.print(">>");
		choice = sc.nextInt();
	}

	public void sellMenu() {
		System.out.println(" << 판매자메뉴>>");
		System.out.println("1. 상품등록");  
		System.out.println("2. 상품 전체 보기"); 
		System.out.println("3. 판매정보 등록 ");
		System.out.println("4. 판매정보 전체보기");
		System.out.println("5. 판매정보 수정");
		System.out.println("6. 판매정보 삭제");
		System.out.println("0. 이전 메뉴 ");
		System.out.print(">>");
		choice = sc.nextInt();
	}

	//

	// 관리자 로그인 회원가입 메뉴.
	public void adminMenu() {
		System.out.println("┌────────────────┐");
		System.out.println("│ 관리자 메뉴                  │");
		System.out.println("│1. 관리자 로그인          │");
		System.out.println("│2. 관리자 회원가입       │");
		System.out.println("│3. 이전메뉴                 │ ");
		System.out.println("└────────────────┘ ");
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

	// 관리자 회원가입
	public void insertAdmin() {
		System.out.println("<<관리자 회원가입 하기>>");
		System.out.print("관리자 이름 : ");
		adminName = scLine.nextLine();
		System.out.print("관리자 아이디 : ");
		adminId = scLine.nextLine();
		System.out.print("관리자 패스워드 : ");
		adminPw = scLine.nextLine();
		System.out.print("관리자 핸드폰번호 : ");
		adminPhone = scLine.nextLine();
		System.out.print("관리자 주소 : ");
		adminAddress = scLine.nextLine();
		System.out.print("회원 일련번호 : ");
		no = scLine.nextLine();

		Admin admin = new Admin(adminName, adminId, adminPw, adminPhone, adminAddress, no);
		if (iven.insertAdmin(admin) == 1) {
			System.out.println("관리자 회원 가입 완료!!");
		} else {
			System.out.println("관리자 회원가입 실패!");
		}

	}

	// 관리자 로그인
	public boolean adminLogin() {
		boolean result = true;
		System.out.println("[[관리자 로그인]]");
		System.out.print("관리자 아이디 : ");
		adminId = scLine.nextLine();
		System.out.print("관리자 비밀번호 : ");
		adminPw = scLine.nextLine();

		Admin admin = new Admin(adminId, adminPw);
		if (iven.loginAdmin(admin)) {
			System.out.println(adminId + "관리자님께서 로그인 하셨습니다.");
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
			System.out.println("** 로그인 실패하셨습니다.");
			adminMenu();
			result = false;
		}
		return result;
	}

	//관리자 로그인된 페이지 
	public void AdminPage() {
		
		System.out.println("┌────────────────────────┐");
		System.out.println("│   [[관리자 회원관리페이지]]   │");
		System.out.println("│1. 가입한 회원 전체 정보 확인하기    │");
		System.out.println("│2. 회원정보 수정                            │");
		System.out.println("│3. 회원정보 삭제                            │");
		System.out.println("│4. 판매자 내역조회                         │");
		System.out.println("│0. 종료                                         │");
		System.out.println("└────────────────────────┘");
		System.out.print(">>");
		
	}
	
	

}
