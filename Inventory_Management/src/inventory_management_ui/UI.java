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
		System.out.println("1. �����ϱ�");
		buyMenu();
		System.out.println("2. ������ �α���");
		admin();
		System.out.println("3. ����");
	}
	
	
	public void buyMenu() {
		System.out.println("1.ȸ������\t2.��ȸ������");
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
	
	//������ ��ǰ Ȯ��. 
	public void showProduct() {
		System.out.println("1.����\t2.���\t3.����ǰ\t4.��Ȱ��ǰ");
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
