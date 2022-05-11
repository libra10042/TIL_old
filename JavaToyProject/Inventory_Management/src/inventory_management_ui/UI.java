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
		System.out.println("1. �����ϱ�");
		buyMenu();
		System.out.println("2. ������ �α���");
		admin();
		System.out.println("3. ����");
	}
	
	
	public void buyMenu(Product p) {
		System.out.println("1.����\t2.���\t3.����ǰ\t4.��Ȱ��ǰ");
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
	
	//�Ǹ����� ��ǰ �����ֱ�. 
	public void showProduct() {
		
		Product instanceof Daily_necessities;
	}
	
	
	
	
	public void admin() {
		System.out.println("1. ���̵� �Է� : ");
		admin_id = scLine.next();
		System.out.println("2. ��й�ȣ �Է� : ");
		admin_pw = scLine.next(); 
		
		sv.checkAdmin(admin_id, admin_pw);
		
	}
	
	
	
	
	public void inventory_info() {
		System.out.println("1. ��� ����");
		System.out.println("2. �Ǹ� ����");
		System.out.println("3. ���� ����");
	}
	
}
