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
	private String userId, userPw, name, address, phone; // ����� ����
	private String adminName, adminId, adminPw, adminPhone, adminAddress; // ������ ����
	private String code, pName, introduce;   //��ǰ
	private int price, amount; //��ǰ, �����
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
						System.out.println(adminId + "�� �������");
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

				
			case "3":
				introduce();
				break;
				
			case "0":
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default :
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �õ����ּ���.");
				continue;
			
			}			
		} catch (Exception e) {
			scLine.nextLine();
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �õ����ּ���.");
			continue;
		} 

	}
}
	/*------------------------------------------Ȩ---------------------------------------------*/ 
	public void home() {
	
			try {

				System.out.println("��������������������������������������������");
				System.out.println("��    [ �ԡ������� ]    ��");
				System.out.println("��                    ��");
				System.out.println("��1. ������                         ��");
				System.out.println("��2. ȸ������                      ��");
				System.out.println("��3. ������ �Ұ�                  ��");
				System.out.println("��0. ����                            ��");
				System.out.println("��                    ��");
				System.out.println("��������������������������������������������");
				System.out.print(">>");
				
			} catch (Exception e) {
				sc.nextLine();
				
			}
		}
	
	public void introduce() {		
		
		
		System.out.println("\t"+"==����Ե� �������� �� ������ ������ ��ο� ����� �����ǰ̴ϱ�?? "
				+ "�ԡ���� ������ ���� ���ϰ� �����ϼ���=="
						+ "\n" +"\t"+"\t"+"\t"+"\t"+ "���� ���� �̿� ��Ź�帳�ϴ�.����" +"\t"+ "\n");
	}
	
	public void homeView() {
		while (true) {
			try {
				home();
				String answer = scLine.nextLine();
				switch (answer) {
			// �α��� �޴�
				
			case "1":
					if (login()) {
						System.out.println(adminId + " �� �������");
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

				
			case "3":
				introduce();
				continue;
				
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
	
	
	/*-----------------------------------------------------------------------------------------*/ 
	/*--------------------------------������ & ����� �α��� ȸ������---------------------------------------*/ 
	// �α��� �ϱ�.
	public boolean login() {
		boolean flag = true;
		System.out.println("�α��� ���ּ���.");
		System.out.print("ID : ");
		adminId = scLine.nextLine();
		System.out.print("PW : ");
		adminPw = scLine.nextLine();

		Admin m = new Admin(adminId, adminPw);
		
		while (flag) {
			
			if(iven.login(m)) {				
				return flag;
		
			}else {
				System.out.println(">> �α��� ���� [Ȩ�޴��� ���ư��÷��� 'HOME'�Է�||�ٽ� �õ� �Ͻ÷��� 'Y'] ");
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
		System.out.println("[Ȩ�޴��� ���ư��÷���'HOME'�Է�] ");
		home();
	}
	// ȸ������ ������
	public boolean insertMember() {
		boolean flag = true;
		System.out.println("[[ ȸ�� ��� ������ ]]");
		System.out.print("ȸ�� ���̵� :");
		adminId = scLine.nextLine();
		System.out.print("ȸ�� ��й�ȣ : ");
		adminPw = scLine.nextLine();
		System.out.print("ȸ�� �̸� : ");
		name = scLine.nextLine();
		System.out.print("ȸ�� �ּ� : ");
		address = scLine.nextLine();
		System.out.print("ȸ�� ��ȭ��ȣ : ");
		phone = scLine.nextLine();


		Admin m = new Admin(adminId, adminPw, name, address, phone);

		
		while (flag) {
			
			if(iven.insertMember(m)) {
				System.out.println("ȸ������ �Ϸ�Ǿ����ϴ�.");
				return flag;
				
			}else {
				System.out.println("** ȸ������ �����Դϴ�. �ٽ� �õ��ϼ���.");
				insertMember();
				flag = false;
			}
		}
		return flag; 
	}


	
	
	/*-----------------------------------------------------------------------------------------*/ 
	/*-------------------------------- �Ǹ���  ������ -----------------------------------------*/ 
	
		
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
						System.out.println("\t"+"\t"+"\t"+"\t"+"     [[���� ���� �Ұ�]]");
						System.out.println("\t"+"\t"+"\t"+"   ���� ����� ���꼾�ʹ� ���� ���� ������ ��ǰ�մϴ�.");
						continue;
					case "0":
						
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
						
					default:
						System.out.println("�߸������̽��ϴ�. �ٽ� �õ����ּ���.");
						continue;
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
					System.out.println("[ �԰� ���� ��� ]");
					System.out.print("�԰��ڵ� : ");
					String code = scLine.next();
					System.out.print("��ǰ�� : ");
					String pname = scLine.next();
					System.out.print("�ܰ� : ");
					int price = scLine.nextInt();
					scLine.nextLine();
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
						System.out.println("** �԰�� ��ǰ�� �����ϴ� **");
						break;
					}
					System.out.println("[ �԰� ���� ��ü���� ]");
					System.out.printf("%-10s%-20s%-10s\n", "�԰��ڵ�", "��ǰ��", "����");
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

		private void insertSales() { //������� ���
			int result = 0;
			while (true) {
				try {
					System.out.println("[ ��� ���� ��� ]");
					System.out.print("����ڵ� : ");
					String code = scLine.next();
					System.out.print("������ : ");
					int quantity = sc.nextInt();
					scLine.nextLine();
					
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
					System.out.println("[ ��� ���� ��ü���� ]");
					System.out.printf("%-10s%-20s%-20s%-20s\n", "�Ϸù�ȣ", "�԰��ڵ�", "����", "�����");
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
					System.out.println("[ ��� ���� ���� ]");
					System.out.print("�Ϸ� ��ȣ : ");
					String code = scLine.next();
					System.out.println("������ : ");
					int quantity = sc.nextInt();
					scLine.nextLine();
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
					System.out.println("  [   ��� ���       ]");
					System.out.println("����� �Ϸù�ȣ : ");
					int num = scLine.nextInt();
					scLine.nextLine();

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
						System.out.println("** ���� ��ǰ�� �����ϴ� **");
						break;
					}
					System.out.println("[ ��ǰ�� ��� ��Ȳ ] ");
					System.out.printf("%-15s%-15s%-20s%-10s\n", "����ڵ�", "��ǰ��", "����", "�������");
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

	
	

	
	

		// ------------------------------�Ǹ��� �޴�----------------------------
		public void sellMenu() {

			try {
				System.out.println("");
				System.out.println("������������������������������������������");
				System.out.println("��  [   �ԡ�������     ] ��");
				System.out.println("��1. �԰� ���                   ��");
				System.out.println("��2. �԰��� ��ü ����      ��");
				System.out.println("��3. ���                          ��");
				System.out.println("��4. ����� ��ü����       ��");
				System.out.println("��5. ��� ���� ����            ��");
				System.out.println("��6. ��� ���                   ��");
				System.out.println("��7. ��������                    ��");
				System.out.println("��8. ����� ���꼾�� �Ұ�   ��");
				System.out.println("��0. ����                          ��");
				System.out.println("������������������������������������������");
				System.out.print("���� >");

			} catch (Exception e) {
				sc.nextLine();

			}

		}

	}
