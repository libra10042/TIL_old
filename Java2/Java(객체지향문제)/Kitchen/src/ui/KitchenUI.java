package ui;

import java.util.Scanner;

import service.KitchenService;

public class KitchenUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean flag = true;
	private int choice, price;
	private String name, address, phoneNum, tableNo, orderNo;
	private KitchenService ks = new KitchenService();

	public KitchenUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(ks.getOrderList());
				break;
			case 2:

				System.out.println("주문번호 입력:");
				orderNo = scLine.nextLine();
				
				ks.completeFood(ks.searchFood(orderNo));
				
				break;
			}
		}
	}

	public void menu() {
		System.out.println("====================");
		System.out.println("1.만들어야하는 음식리스트");
		System.out.println("2.완성음식등록(주문번호로)");
		System.out.println("=====================");
	}
	
	
	
	
	
	
}
