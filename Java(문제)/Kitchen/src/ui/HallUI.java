package ui;

import java.util.Scanner;

import service.KitchenService;
import vo.Customer;
import vo.DineIn;
import vo.Food;
import vo.TakeOut;

public class HallUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean flag = true;
	private int choice, price;
	private String name, address, phoneNum, tableNo, orderNo;
	private KitchenService ks = new KitchenService();

	public HallUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (ks.insertCustomer(makeCustomer())) {
					System.out.println("등록성공");
				} else {
					System.out.println("등록실패****(같은 핸드폰번호존재)");
				}
				break;
			case 2:
				System.out.println("주문 하는 사람의 핸드폰번호 입력 : ");
				phoneNum = scLine.nextLine();

				if (ks.orderFood(phoneNum, makeFood())) {
					System.out.println("주문성공");
				} else {
					System.out.println("존재하지 않는 고객입니다.");
				}

				break;
			case 3:
				System.out.println("검색 하는 사람의 핸드폰번호 입력 : ");
				phoneNum = scLine.nextLine();
				Customer c = ks.searchCustomer(phoneNum);
				if (c == null) {
					System.out.println("검색하려는 사람이 없습니다.");
				} else {
					System.out.println(c);
				}
				break;
			case 4:
				System.out.println("검색 하려는 음식의 주문번호 입력 : ");
				orderNo = scLine.nextLine();
				Food f = ks.searchFood(orderNo);
				if (f == null) {
					System.out.println("검색하려는 음식이 없습니다.");
				} else {
					System.out.println(f);
				}
				break;
			case 5:
				if(ks.getComplete()==null) {
					System.out.println("완성된 음식이 없습니다.(음식 준비중...)");
				}else {
					System.out.println(ks.getComplete());					
				}
				break;
			case 6:
				System.out.println("완료된 음식 주문 번호 : ");
				orderNo = scLine.nextLine();
				System.out.println(ks.serveFood(orderNo));
				break;
			case 7:
				System.out.println(ks.mostBoughtCustomer());
				break;
			case 8:
				System.out.println(ks.calculateAll());
				break;
			case 9:
				flag = false;
				break;
			}
		}
	}

	public void menu() {
		System.out.println("===================");
		System.out.println("1.고객등록");
		System.out.println("2.음식주문");
		System.out.println("3.고객검색");
		System.out.println("4.주문음식검색");
		System.out.println("5.완성된음식확인");
		System.out.println("6.완성된음식서빙/배달");
		System.out.println("7.단골고객확인");
		System.out.println("8.매출확인");
		System.out.println("9.종료");
		System.out.println("===================");
	}

	public Customer makeCustomer() {
		System.out.println("이름 입력 : ");
		name = scLine.nextLine();
		System.out.println("핸드폰 입력 : ");
		phoneNum = scLine.nextLine();

		return new Customer(name, phoneNum);
	}

	public Food makeFood() {

		Food result = null;
		System.out.println("1.매장내주문");
		System.out.println("2.배달주문");
		System.out.println("===================");
		choice = sc.nextInt();

		System.out.println("주문번호 입력 : ");
		orderNo = scLine.nextLine();
		System.out.println("음식명 입력 : ");
		name = scLine.nextLine();
		System.out.println("가격 입력 : ");
		price = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("테이블번호 입력 : ");
			tableNo = scLine.nextLine();

			result = new DineIn(orderNo, name, price, tableNo);
			break;
		case 2:
			System.out.println("주소 입력 : ");
			address = scLine.nextLine();

			result = new TakeOut(orderNo, name, price, address);
			break;
		}
		return result;

	}

}
