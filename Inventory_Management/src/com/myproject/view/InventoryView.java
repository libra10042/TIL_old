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
						System.out.println(userId + "�� �������");
						sellView();
					}
					break;

				case "2":
					if (insertMember()) {
						System.out.println("ȸ�� ���� �Ϸ�.");
					} else {
						System.out.println("ȸ�� ���� ����.");
					}
					break;

				case "0":
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
				}
			} catch (Exception e) {
				scLine.nextLine();
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��߽��ϴ�");
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
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);

				}
			} catch (Exception e) {
				scLine.nextLine();
				System.out.println("�߸��Է��ϼ̽��ϴ� �ٽ� �Է����ּ���");
				continue;
			}
		}

	}

	private void insertProduct() {
		int result = 0;
		while (true) {
			try {
				System.out.println("[ ��ǰ ���� ��� ]");
				System.out.print("��ǰ�ڵ� : ");
				String code = scLine.next();
				System.out.print("��ǰ�� : ");
				String pname = scLine.next();
				System.out.print("�ܰ� : ");
				int price = sc.nextInt();
				
				if (price < 0) {
					System.out.println("0������ ���ڴ� �Է��Ͻ� �� �����ϴ�.");
					break;
				}

				Product product = new Product(code, pname, price);

				result = iven.insertProduct(product);

				if (result > 0) {
					System.out.println("* ����Ǿ����ϴ�.");
					break;
				} else
					System.out.println("* ���忡 �����Ͽ����ϴ�.");
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
					System.out.println("** ��ϵ� ��ǰ�� �����ϴ� **");
					break;
				}
				System.out.println("[ ��ǰ ���� ]");
				System.out.printf("%-10s%-10s%-10s\n", "��ǰ�ڵ�", "��ǰ��", "����");
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
				System.out.println("[ �Ǹ� ���� ��� ]");
				System.out.print("��ǰ�ڵ� : ");
				String code = scLine.next();
				System.out.print("�Ǹż��� : ");
				int quantity = scLine.nextInt();
				if (quantity < 1) {
					System.out.println("1�̻��� ���ڸ� �Է����ּ���");
					break;
				}

				Sales vo = new Sales();
				vo.setCode(code);
				vo.setQuantity(quantity);

				result = iven.insert(vo);

				if (result > 0) {
					System.out.println("* ����Ǿ����ϴ�.");
					break;
				} else
					System.out.println("* ���忡 �����Ͽ����ϴ�.");

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
				System.out.println("[ �Ǹ� ���� ]");
				System.out.printf("%-10s%-20s%-20s%-20s\n", "�Ϸù�ȣ", "��ǰ�ڵ�", "����", "��ǰ�ǸŰ�����");
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
				System.out.println("[ �Ǹ� ���� ���� ]");
				System.out.print("������ ��ȣ : ");
				String code = scLine.next();
				System.out.println("�Ǹż��� : ");
				int quantity = sc.nextInt();
				if (quantity < 1) {
					System.out.println("1�̻��� ���ڸ� �Է����ּ���");
					break;
				}

				Sales vo = new Sales();
				vo.setCode(code);
				vo.setQuantity(quantity);

				result = iven.update(vo);

				if (result > 0) {
					System.out.println("* �����Ǿ����ϴ�.");
					break;
				} else
					System.out.println("* ������ �����Ͽ����ϴ�");

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
				System.out.println("[ �Ǹ� ���� ���� ]");
				System.out.println("������ ��ȣ : ");
				int num = scLine.nextInt();

				result = iven.delete(num);

				if (result > 0) {
					System.out.println("* �����Ǿ����ϴ�.");
					break;
				} else
					System.out.println("* ������ �����Ͽ����ϴ�.");

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
					System.out.println("** �Ǹŵ� ��ǰ�� �����ϴ� **");
					break;
				}
				System.out.println("[ ��ǰ�� �Ǹ� ��Ȳ ] ");
				System.out.printf("%-15s%-15s%-20s%-10s\n", "��ǰ�ڵ�", "��ǰ��", "����", "�������");
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

	// --------------------------------Ȩ--------------------------------
	public void home() {
		while (true) {
			try {

				System.out.println("������������������������������");
				System.out.println("��[����� �������] ��");
				System.out.println("��1. �α���             ��");
				System.out.println("��2. ȸ������          ��");
				System.out.println("��0. ����                ��");
				System.out.println("������������������������������");
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
		System.out.println("�α��� ���ּ���.");
		System.out.print("ID : ");
		userId = scLine.nextLine();
		System.out.print("PW : ");
		userPw = scLine.nextLine();

		Member m = new Member(userId, userPw);

		if (iven.login(m)) {
			System.out.println(userId + "�� ȯ���մϴ�.");
			return flag;
		} else {
			System.out.println(">> �α��ο� �����ϼ̽��ϴ�.");
			flag = false;
		}
		return flag;

	}

	public boolean insertMember() {
		boolean flag = false;
		System.out.println("[[ ȸ�� ��� ������ ]]");
		System.out.print("ȸ�� ���̵� :");
		userId = scLine.nextLine();
		System.out.print("ȸ�� ��й�ȣ : ");
		userPw = scLine.nextLine();
		System.out.print("ȸ�� �̸� : ");
		name = scLine.nextLine();
		System.out.print("ȸ�� �ּ� : ");
		address = scLine.nextLine();
		System.out.print("ȸ�� ��ȭ��ȣ : ");
		phone = scLine.nextLine();

		Member m = new Member(userId, userPw, name, address, phone);

		if (iven.insertMember(m)) {
			flag = true;
		}
		return flag;

	}

	// ------------------------------�Ǹ��� �޴�----------------------------
	public void sellMenu() {
		while (true) {
			try {
				System.out.println("");
				System.out.println("������������������������������������������");
				System.out.println("��[   �ǸŰ���      ]      ��");
				System.out.println("��1. ��ǰ ���                       ��");
				System.out.println("��2. ��ǰ ��ü ����                ��");
				System.out.println("��3. �Ǹ����� ���                 ��");
				System.out.println("��4. �Ǹ����� ��ü����           ��");
				System.out.println("��5. �Ǹ����� ����                 ��");
				System.out.println("��6. �Ǹ����� ����                 ��");
				System.out.println("��7. �ǸŻ�ǰ ���� ��������    ��");
				System.out.println("��0. ����                              �� ");
				System.out.println("������������������������������������������");
				System.out.print("���� >");
				break;
			} catch (Exception e) {
				sc.nextLine();
				break;
			}
		}
	}

}
