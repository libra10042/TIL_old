package com.myproject.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.myproject.dao.InventoryDAO;
import com.myproject.vo.Admin;
import com.myproject.vo.Product;
import com.myproject.vo.Sales;
import com.myproject.vo.SalesList;

public class InventoryView {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean flag = true;
	private int choice;
	private String userId, userPw, name, address, phone; // 사용자 정보
	private String adminName, adminId, adminPw, adminPhone, adminAddress; // 관리자 정보
	private String code, pName, introduce;   //상품
	private int price, amount; //상품, 입출고
	private String pCode;
	private Date inputdate;
	private String check;
	private InventoryDAO iven = new InventoryDAO();

	public InventoryView() {
		while (true) {
			try {
				home();
				String answer = scLine.nextLine();
				switch (answer) {			
				
			case "1":
					if (login()) {
						System.out.println(adminId + "님 어서오세요");
						sellView();
					}
					break;
				
			
			case "2":
				if (insertMember()) {
					System.out.println("회원 가입 완료.");
				} else {
					System.out.println("회원 가입 실패.");
				}
				break;

				
			case "3":
				introduce();
				break;
				
			case "0":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
				continue;
			
			}			
		} catch (Exception e) {
			scLine.nextLine();
			System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
			continue;
		} 

	}
}
	/*------------------------------------------홈---------------------------------------------*/ 
	public void home() {
	
			try {

				System.out.println("┌────────────────────┐");
				System.out.println("│    [ 입·출고관리 ]    │");
				System.out.println("│                    │");
				System.out.println("│1. 관리자                         │");
				System.out.println("│2. 회원가입                      │");
				System.out.println("│3. 간단한 소개                  │");
				System.out.println("│0. 종료                            │");
				System.out.println("│                    │");
				System.out.println("└────────────────────┘");
				System.out.print(">>");
				
			} catch (Exception e) {
				sc.nextLine();
				
			}
		}
	
	public void introduce() {		
		
		
		System.out.println("\t"+"==사장님들 언제까지 손 아프게 일일이 장부에 수기로 적으실겁니까?? "
				+ "입·출고 내역을 보다 편리하게 관리하세요=="
						+ "\n" +"\t"+"\t"+"\t"+"\t"+ "♥♥ 많은 이용 부탁드립니다.♥♥" +"\t"+ "\n");
	}
	
	public void homeView() {
		while (true) {
			try {
				home();
				String answer = scLine.nextLine();
				switch (answer) {
			// 로그인 메뉴
				
			case "1":
					if (login()) {
						System.out.println(adminId + " 님 어서오세요");
						sellView();
					}
					break;
				
			
			case "2":
				if (insertMember()) {
					System.out.println("회원 가입 완료.");
				} else {
					System.out.println("회원 가입 실패.");
				}
				break;

				
			case "3":
				introduce();
				continue;
				
			case "0":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
			}			
		} catch (Exception e) {
			scLine.nextLine();
			System.out.println("잘못입력하셨습니다. 다시 입력했습니다");
			continue;
		}
		}
	}
	
	
	/*-----------------------------------------------------------------------------------------*/ 
	/*--------------------------------관리자 & 사용자 로그인 회원가입---------------------------------------*/ 
	// 로그인 하기.
	public boolean login() {
		boolean flag = true;
		System.out.println("로그인 해주세요.");
		System.out.print("ID : ");
		adminId = scLine.nextLine();
		System.out.print("PW : ");
		adminPw = scLine.nextLine();

		Admin m = new Admin(adminId, adminPw);
		
		while (flag) {
			
			if(iven.login(m)) {				
				return flag;
		
			}else {
				System.out.println(">> 로그인 실패 [홈메뉴로 돌아가시려면 'HOME'입력||다시 시도 하시려면 'Y'] ");
				System.out.print(">> ");
				check = scLine.nextLine();
				
				if("HOME".equals(check)) {
					
					homeView();
					
					break;
				
				}else if("Y".equals(check)){
					login();
					break;
				}
			}			
		}
		return flag;
	}

	public void failLogin() {
		System.out.println("[홈메뉴로 돌아가시려면'HOME'입력] ");
		home();
	}
	// 회원가입 페이지
	public boolean insertMember() {
		boolean flag = true;
		System.out.println("[[ 회원 등록 페이지 ]]");
		System.out.print("회원 아이디 :");
		adminId = scLine.nextLine();
		System.out.print("회원 비밀번호 : ");
		adminPw = scLine.nextLine();
		System.out.print("회원 이름 : ");
		name = scLine.nextLine();
		System.out.print("회원 주소 : ");
		address = scLine.nextLine();
		System.out.print("회원 전화번호 : ");
		phone = scLine.nextLine();


		Admin m = new Admin(adminId, adminPw, name, address, phone);

		
		while (flag) {
			
			if(iven.insertMember(m)) {
				System.out.println("회원가입 완료되었습니다.");
				return flag;
				
			}else {
				System.out.println("** 회원가입 실패입니다. 다시 시도하세요.");
				insertMember();
				flag = false;
			}
		}
		return flag; 
	}


	
	
	/*-----------------------------------------------------------------------------------------*/ 
	/*-------------------------------- 판매자  페이지 -----------------------------------------*/ 
	
		
		public void sellView() {
			while (true) {
				try {
					sellMenu();
					String answer = scLine.nextLine();
	
					switch (answer) {
					case "1":
						insertProduct();
						break;
					case "2":
						selectAllProduct();
						break;
					case "3":
						insertSales();
						break;
					case "4":
						selectAllSales();
						break;
					case "5":
						updateSales();
						break;
					case "6":
						deleteSales();
						break;
					case "7":
						selectOneSales();
						break;
					case "8":
						System.out.println("\t"+"\t"+"\t"+"\t"+"     [[수산 센터 소개]]");
						System.out.println("\t"+"\t"+"\t"+"   저희 건희네 수산센터는 당일 잡힌 생선만 납품합니다.");
						continue;
					case "0":
						
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
						
					default:
						System.out.println("잘못누르셨습니다. 다시 시도해주세요.");
						continue;
					}
				} catch (Exception e) {
					scLine.nextLine();
					System.out.println("잘못입력하셨습니다 다시 입력해주세요");
					continue;
				}
			}

		}

		private void insertProduct() {
			int result = 0;
			while (true) {
				try {
					System.out.println("[ 입고 정보 등록 ]");
					System.out.print("입고코드 : ");
					String code = scLine.next();
					System.out.print("상품명 : ");
					String pname = scLine.next();
					System.out.print("단가 : ");
					int price = scLine.nextInt();
					scLine.nextLine();
					if (price < 0) {
						System.out.println("0이하의 숫자는 입력하실 수 없습니다.");
						break;
					}

					Product product = new Product(code, pname, price);

					result = iven.insertProduct(product);
				
					if (result > 0) {
						System.out.println("* 저장되었습니다.");
						break;
					} else
						System.out.println("* 저장에 실패하였습니다.");
						
						break;
				} catch (Exception e) {
					scLine.nextLine();
					break;
				}
			}
		}

		private void selectAllProduct() {
			ArrayList<Product> plist = new ArrayList<Product>();
			while (true) {
				try {
					plist = iven.listProduct();
					if (plist.size() < 0) {
						System.out.println("** 입고된 상품이 없습니다 **");
						break;
					}
					System.out.println("[ 입고 내역 전체보기 ]");
					System.out.printf("%-10s%-20s%-10s\n", "입고코드", "상품명", "가격");
					System.out.println("===================================");

					for (Product p : plist) {
						System.out.printf("%-10s%-10s%-10d\n", p.getCode(), p.getPname(), p.getPrice());
					}
					break;
				} catch (Exception e) {
					scLine.nextLine();
					break;
				}
			}
		}

		private void insertSales() { //출고정보 등록
			int result = 0;
			while (true) {
				try {
					System.out.println("[ 출고 정보 등록 ]");
					System.out.print("출고코드 : ");
					String code = scLine.next();
					System.out.print("출고수량 : ");
					int quantity = sc.nextInt();
					scLine.nextLine();
					
					if (quantity < 1) {
						System.out.println("1이상의 숫자를 입력해주세요");
						break;
					}

					Sales vo = new Sales();
					vo.setCode(code);
					vo.setQuantity(quantity);

					result = iven.insert(vo);

					if (result > 0) {
						System.out.println("* 저장되었습니다.");
						break;
					} else
						System.out.println("* 저장에 실패하였습니다.");
						
					break;
						
				} catch (Exception e) {
					scLine.nextLine();
					break;
				}
			}
		}

		private void selectAllSales() {
			ArrayList<Sales> slist = new ArrayList<Sales>();
			while (true) {
				try {
					System.out.println("[ 출고 내역 전체보기 ]");
					System.out.printf("%-10s%-20s%-20s%-20s\n", "일련번호", "입고코드", "수량", "출고일");
					System.out.println("=========================================");

					slist = iven.list();

					for (Sales s : slist) {
						System.out.printf("%-10d%-10s%-10d%-10s\n", s.getNum(), s.getCode(), s.getQuantity(),
								s.getInputdate());
					}
					break;

				} catch (Exception e) {
					break;
				}
			}
		}

		private void updateSales() {
			int result = 0;

			while (true) {
				try {
					System.out.println("[ 출고 정보 수정 ]");
					System.out.print("일련 번호 : ");
					String code = scLine.next();
					System.out.println("출고수량 : ");
					int quantity = sc.nextInt();
					scLine.nextLine();
					if (quantity < 1) {
						System.out.println("1이상의 숫자를 입력해주세요");
						break;
					}

					Sales vo = new Sales();
					vo.setCode(code);
					vo.setQuantity(quantity);

					result = iven.update(vo);

					if (result > 0) {
						System.out.println("* 수정되었습니다.");
						break;
					} else
						System.out.println("* 수정에 실패하였습니다");

					break;
				} catch (Exception e) {
					scLine.nextLine();
					break;
				}
			}
		}

		private void deleteSales() {
			int result = 0;
			while (true) {
				try {
					System.out.println("  [   출고 취소       ]");
					System.out.println("취소할 일련번호 : ");
					int num = scLine.nextInt();
					scLine.nextLine();

					result = iven.delete(num);

					if (result > 0) {
						System.out.println("* 삭제되었습니다.");
						break;
					} else
						System.out.println("* 삭제에 실패하였습니다.");

					break;
				} catch (Exception e) {
					scLine.nextLine();
					break;
				}
			}
		}

		private void selectOneSales() {
			ArrayList<SalesList> slist = new ArrayList<SalesList>();

			while (true) {
				try {
					slist = iven.sales();
					if (slist.size() < 1) {
						System.out.println("** 출고된 상품이 없습니다 **");
						break;
					}
					System.out.println("[ 상품별 출고 현황 ] ");
					System.out.printf("%-15s%-15s%-20s%-10s\n", "출고코드", "상품명", "수량", "예상수익");
					System.out.println("====================================");

					for (SalesList s : slist) {
						System.out.printf("%-10s%-10s%-10d%-10d\n", s.getCode(), s.getPname(), s.getQuantity(),
								s.getSaleAmount());
					}
					break;

				} catch (Exception e) {
					scLine.nextLine();
					break;
				}
			}
		}

	
	

	
	

		// ------------------------------판매자 메뉴----------------------------
		public void sellMenu() {

			try {
				System.out.println("");
				System.out.println("┌───────────────────┐");
				System.out.println("│  [   입·출고관리     ] │");
				System.out.println("│1. 입고 등록                   │");
				System.out.println("│2. 입고내역 전체 보기      │");
				System.out.println("│3. 출고                          │");
				System.out.println("│4. 출고내역 전체보기       │");
				System.out.println("│5. 출고 수량 변경            │");
				System.out.println("│6. 출고 취소                   │");
				System.out.println("│7. 매출정보                    │");
				System.out.println("│8. 건희네 수산센터 소개   │");
				System.out.println("│0. 종료                          │");
				System.out.println("└───────────────────┘");
				System.out.print("선택 >");

			} catch (Exception e) {
				sc.nextLine();

			}

		}

	}
