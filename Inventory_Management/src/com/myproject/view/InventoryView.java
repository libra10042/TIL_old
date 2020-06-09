package com.myproject.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.myproject.dao.InventoryDAO;
import com.myproject.vo.Member;
import com.myproject.vo.Product;
import com.myproject.vo.Sales;
import com.myproject.vo.SalesList;

public class InventoryView {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean flag = true;
	private int choice;
	private String userId, userPw, name, address, phone;
	private String code, pname;
	private int price, num, quantity;
	private String inputdate;

	private InventoryDAO iven = new InventoryDAO();

	public InventoryView() {
		while (true) {
			try {
				home();
				String answer = scLine.nextLine();
				switch (answer) {
				case "1":
					if (login()) {
						System.out.println(userId + "님 어서오세요");
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
				case "0":
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);

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
				System.out.println("[ 상품 정보 등록 ]");
				System.out.print("상품코드 : ");
				String code = scLine.next();
				System.out.print("상품명 : ");
				String pname = scLine.next();
				System.out.print("단가 : ");
				int price = sc.nextInt();
				
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
					System.out.println("** 등록된 상품이 없습니다 **");
					break;
				}
				System.out.println("[ 상품 정보 ]");
				System.out.printf("%-10s%-10s%-10s\n", "상품코드", "상품명", "가격");
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

	private void insertSales() {
		int result = 0;
		while (true) {
			try {
				System.out.println("[ 판매 정보 등록 ]");
				System.out.print("상품코드 : ");
				String code = scLine.next();
				System.out.print("판매수량 : ");
				int quantity = scLine.nextInt();
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
				System.out.println("[ 판매 정보 ]");
				System.out.printf("%-10s%-20s%-20s%-20s\n", "일련번호", "상품코드", "수량", "상품판매개시일");
				System.out.println("=========================================");

				slist = iven.list();

				for (Sales s : slist) {
					System.out.printf("%-10d%-20s%-20d%-20s\n", s.getNum(), s.getCode(), s.getQuantity(),
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
				System.out.println("[ 판매 정보 수정 ]");
				System.out.print("수정할 번호 : ");
				String code = scLine.next();
				System.out.println("판매수량 : ");
				int quantity = sc.nextInt();
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
				System.out.println("[ 판매 정보 삭제 ]");
				System.out.println("삭제할 번호 : ");
				int num = scLine.nextInt();

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
					System.out.println("** 판매된 상품이 없습니다 **");
					break;
				}
				System.out.println("[ 상품별 판매 현황 ] ");
				System.out.printf("%-15s%-15s%-20s%-10s\n", "상품코드", "상품명", "수량", "예상수익");
				System.out.println("====================================");

				for (SalesList s : slist) {
					System.out.printf("%-15s%-10s%-10d%-10d\n", s.getCode(), s.getPname(), s.getQuantity(),
							s.getSaleAmount());
				}
				break;

			} catch (Exception e) {
				scLine.nextLine();
				break;
			}
		}
	}

	// --------------------------------홈--------------------------------
	public void home() {
		while (true) {
			try {

				System.out.println("┌─────────────┐");
				System.out.println("│[건희네 수산시장] │");
				System.out.println("│1. 로그인             │");
				System.out.println("│2. 회원가입          │");
				System.out.println("│0. 종료                │");
				System.out.println("└─────────────┘");
				System.out.print(">>");
				break;
			} catch (Exception e) {
				sc.nextLine();
				break;
			}
		}
	}

	public boolean login() {
		boolean flag = true;
		System.out.println("로그인 해주세요.");
		System.out.print("ID : ");
		userId = scLine.nextLine();
		System.out.print("PW : ");
		userPw = scLine.nextLine();

		Member m = new Member(userId, userPw);

		if (iven.login(m)) {
			System.out.println(userId + "님 환영합니다.");
			return flag;
		} else {
			System.out.println(">> 로그인에 실패하셨습니다.");
			flag = false;
		}
		return flag;

	}

	public boolean insertMember() {
		boolean flag = false;
		System.out.println("[[ 회원 등록 페이지 ]]");
		System.out.print("회원 아이디 :");
		userId = scLine.nextLine();
		System.out.print("회원 비밀번호 : ");
		userPw = scLine.nextLine();
		System.out.print("회원 이름 : ");
		name = scLine.nextLine();
		System.out.print("회원 주소 : ");
		address = scLine.nextLine();
		System.out.print("회원 전화번호 : ");
		phone = scLine.nextLine();

		Member m = new Member(userId, userPw, name, address, phone);

		if (iven.insertMember(m)) {
			flag = true;
		}
		return flag;

	}

	// ------------------------------판매자 메뉴----------------------------
	public void sellMenu() {
		while (true) {
			try {
				System.out.println("");
				System.out.println("┌───────────────────┐");
				System.out.println("│[   판매관리      ]      │");
				System.out.println("│1. 상품 등록                       │");
				System.out.println("│2. 상품 전체 보기                │");
				System.out.println("│3. 판매정보 등록                 │");
				System.out.println("│4. 판매정보 전체보기           │");
				System.out.println("│5. 판매정보 수정                 │");
				System.out.println("│6. 판매정보 삭제                 │");
				System.out.println("│7. 판매상품 예상 매출정보    │");
				System.out.println("│0. 종료                              │ ");
				System.out.println("└───────────────────┘");
				System.out.print("선택 >");
				break;
			} catch (Exception e) {
				sc.nextLine();
				break;
			}
		}
	}

}
