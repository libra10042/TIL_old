package inventory_management_ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inventory_management_controller.Service;
import inventory_management_vo.Admin;
import inventory_management_vo.Daily_necessities;
import inventory_management_vo.Product;

public class UI {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private Service sv = new Service();
	private boolean flag=true;
	private int choice;
	private List<> p_list = ArrayList<>();
	
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
	
	
	public void buyMenu(Product p) {
		System.out.println("1.음료\t2.라면\t3.유제품\t4.생활용품");
		choice = sc.nextInt(); 
		
		switch(choice) {
		case 1: 
			if(p instanceof Daily_necessities) {
				
			}
			
			break;
			
		case 2: 
			showProduct(); 
			
			break;
		}
		
	}
	
	//판매중인 제품 보여주기. 
	public void showProduct() {
		
		Product instanceof Daily_necessities;
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
