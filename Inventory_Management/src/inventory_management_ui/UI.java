package inventory_management_ui;

import java.util.Scanner;

import inventory_management_controller.Service;
import inventory_management_vo.Admin;

public class UI {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private Service sv = new Service();
	private boolean flag=true;
	private int choice;
	
	private String admin_id, admin_pw, admin_name, admin_email;
	
	
	public UI() {
		while(flag) {
			
		}
	
	
	}
	
	public void MainMenu() {
		System.out.println("1. 구매하기");
		buyMenu();
		System.out.println("2. 관리자 로그인");
		admin();
		System.out.println("3. 종료");
	}
	
	
	public void buyMenu() {
		System.out.println("1.회원구매\t2.비회원구매");
		choice = sc.nextInt(); 
		
		switch(choice) {
		case 1: 
			showProduct(); 
			
			break;
			
		case 2: 
			showProduct(); 
			
			break;
		}
			
	}
	
	//구매할 제품 확인. 
	public void showProduct() {
		System.out.println("1.음료\t2.라면\t3.유제품\t4.생활용품");
		choice = sc.nextInt(); 
		switch(choice) {
		case 1: 
			
			break;
			
		case 2:
			
			break;
			
		case 3:
			
			break;
			
		case 4: 
			
			break;
		}
	}
	
	
	
	
	public void admin() {
		System.out.println("1. 아이디 입력 : ");
		admin_id = scLine.next();
		System.out.println("2. 비밀번호 입력 : ");
		admin_pw = scLine.next(); 
		
		sv.checkAdmin(admin_id, admin_pw);
		
	}
	
	
	
	
	public void inventory_info() {
		System.out.println("1. 재고 관리");
		System.out.println("2. 판매 관리");
		System.out.println("3. 구매 관리");
	}
	
}
