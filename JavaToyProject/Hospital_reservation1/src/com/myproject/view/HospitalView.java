package com.myproject.view;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.myproject.dao.CustomerDao;
import com.myproject.dao.DoctorDao;
import com.myproject.vo.Clients;
import com.myproject.vo.Doctor;
import com.myproject.vo.Part;
import com.myproject.vo.Reserve;

public class HospitalView {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private int choice; 
	private String clname, clpn, clphone, doname, password, info_doctor, partname; 
	private String sympton;
	private int renumber, clnumber, donumber, partnumber;
	private Date schedule;
	private CustomerDao hd = new CustomerDao(); 
	private DoctorDao dd = new DoctorDao(); 
	
	private boolean flag = true;
	
	public HospitalView() {
		
		while(flag) {
			
			Home();
			choice = sc.nextInt(); 
			switch(choice) {
			case 1: 
				visitView(); 
				break;
				
			case 2: 
				reserveAndCancel(); 
				break;
				
			case 3: 
				DoctorIntroduce();
				break;
				
			case 4:
				CustomerInfo();
				break;
			
			}
			
		}
	
	
	}
	
	
	
	//---------------------------------------1. ���� ���� -------------------------------------------
	public void Home() {
		System.out.println("��������������������������������������������");
		System.out.println("��1. ���Ό���ϱ�                    ��");
		System.out.println("��2. ������ȸ �� ���� ���        ��" );
		System.out.println("��3. �Ƿ��� �Ұ�                      ��");
		System.out.println("��4. ������                          ��");
		System.out.println("��5. ����                                ��");
		System.out.println("��������������������������������������������");
		System.out.print(">>");
	}
	
	
	
	
	
	//1-1. ���Ό��   
	public void visitView() {
		System.out.println("����������������������������");
		System.out.println("�� [����ó�Դϴ�] ��");
		System.out.println("��1.ó���湮           ��");
		System.out.println("��2.�����湮           ��");
		System.out.println("����������������������������");
		System.out.print(">>");
		choice = sc.nextInt(); 
		switch(choice) {
		case 1:
			// ����, ����ȣ, �ֹε�Ϲ�ȣ, ��ȭ��ȣ, ���� �Է� ��� �� �Է� �ߴٸ� �����Է� â ���
			insertClients();
			
			break;
			
		case 2:
			existsClients();
			
			break;
		}
	}
	// 1-1. ó���湮 �� ���. 
	public boolean insertClients() {
		
		try {
			flag = false; 
			System.out.println("���� ������ ���� �ʼ������� �Է��մϴ�.");
			System.out.print("�� �̸� �Է� : ");
			clname = scLine.nextLine(); 
			System.out.print("�� �ֹι�ȣ �Է� : ");
			clpn = scLine.nextLine(); 
			System.out.print("�� ��ȭ��ȣ �Է� : ");
			clphone = scLine.nextLine(); 
			
			Clients s = new Clients(clname, clpn, clphone);
			
			
			
			if(hd.insertClients(s)) {
				flag = true;
				System.out.println(">>�� ����� �Ϸ�Ǿ����ϴ�.");
				System.out.print("������ �Է����ּ��� : ");
				sympton = scLine.nextLine(); 
				
				careCheck(); 
			}else {
				System.out.println("**Error ����� �����Դϴ�.");
				return flag; 
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag; 
	}
	
	// 1-2.���� �湮 �� 
	public boolean existsClients() {
		boolean flag = false; 
		System.out.print("������ ��ȣ�� �Է����ּ��� : ");
		clnumber = sc.nextInt();
		
		Clients s = new Clients(clnumber);
		
		if(hd.existsClient(s)) {
			flag = true;
			System.out.println("[[���Ό���� �����մϴ�.]]" );
			System.out.print("������ �Է����ּ��� : ");
			sympton = scLine.nextLine(); 
			
			careCheck();
			
		}else {
			System.out.println("** �������� �ʴ� ȸ���Դϴ�.");
		}
		return false; 
		
		
	}
	
	
	
	
	// �� ��ȣ�� ���� ������ �����ϴ�.
	public void searchClients() {
		//ȯ�ڹ�ȣ �Է�
		System.out.println("ȯ�� ��ȣ�� �Է��ϼ��� :");
		clnumber= sc.nextInt(); 
		
		Clients c = new Clients(clnumber);
		
		
		
	}
	
	//1-2. ���� ����
	public boolean careCheck() {
		boolean flag = false; 
		System.out.println("-----����-----");
		System.out.println("1. ����,    2. �ܰ�,    3.�Ҿư�,    4.�����ܰ�,    5.�Ȱ�");
		System.out.print(">>");
		partnumber = sc.nextInt(); 
		
		Part p = new Part(partnumber); 
		if(dd.selectDoctor(p)) {
			flag = true; 
			System.out.println("[������� ����Ǹ� �����ϼ���]");
			System.out.print(">>");
			donumber = sc.nextInt(); 
			System.out.println("[����ð��� �������ּ���]");
			selectDoctorDate(); 
			
		}else {
			System.out.println("** �ٽ� �������ּ���");
		}
		return flag; 
	}
	
	
	
	
	
	//1-4 ���� ��¥ ���. 
	public void selectDoctorDate() {
		LocalDate localDate = null; 

		//Month month = localDate.getMonth(); 
		//System.out.println(month.getValue());
		
		//10�� 5�� 40�� ǥ��. 
		//LocalTime time = LocalTime.of(10, 5, 40);
		
		
		for(int i=1; i<=7; i++) {
			LocalDate plusDays = localDate.plusDays(i);
			System.out.println(i + "." + plusDays.format(DateTimeFormatter.ISO_DATE));
		}
		
		for(int j=9; j<=17; j++) {
			LocalTime timeSchedule = LocalTime.of(j, 00);
			System.out.println(j + "." + timeSchedule.format(DateTimeFormatter.ISO_DATE));
		}
		
		
		
		//��, ��, �� ���ϱ�
//		Calendar calendar = Calendar.getInstance();
//		int month = calendar.get(calendar.MONTH)+1;
//		int date = calendar.get(Calendar.DATE);
//		
		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.mm.dd HH:MM", Locale.KOREA);
//		Date currentTime = new Date(); 
//		String dTime = formatter.format(currentTime);
//		System.out.println(dTime);
//		
//		
//		System.out.println(month + date);
//		
//		LocalDateTime currentDateTime = LocalDateTime.now(); 
//		
//		LocalDateTime targetDateTime = currentDateTime
//				.plusDays(1);
//		
//		LocalDate time= LocalDate.now();
//		LocalTime date= LocalTime.now(); 
//		
//		
//		for(int i= 1; i<=7; i++) {
//			calendar.add(Calendar.DATE, i); 
//			for(int j=9; j<=17; j++) {
//				calendar.add(Calendar.HOUR, j);
//			}
//			
//			System.out.println(calendar.DATE + ", " + calendar.HOUR);
//		}
//		
//		
//		
//		LocalDateTime nowDateTime = LocalDateTime.now(); 
//		System.out.println(nowDateTime.getMonthValue());
//		System.out.println(nowDateTime.getDayOfMonth());
//		System.out.println(nowDateTime.getHour());
		
		
	}
	
	
	public void reserveAndCancel() {
		System.out.println("��������������������������������������");
		System.out.println("���α��� ������ �������ּ��䦢");
		System.out.println("��1. ��                         ��");
		System.out.println("��2. ����                         ��");
		System.out.println("��3. ��������                   ��");
		System.out.println("��������������������������������������");
		System.out.print(">>");
		choice  = sc.nextInt(); 
		switch(choice) {
		case 1: 
			
			
			break;
			
		case 2:
			
			break;
		case 3: 
		}
	}
	
	

	
	
	//������ȸ �� ���� ���
	public void DoctorInfo() {
		
	}
	
	//�Ƿ��� �Ұ�
	public void DoctorIntroduce() {
		System.out.println("�Ƿ��� �Ұ�");
		System.out.printf("%-25s%-20s%-25s%-20s%n", "�̸�", "����", "�з�", "���" );
		System.out.println("======================================================");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "������", "����", "����� ����", "�����������10�� ���");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "�����", "�ܰ�", "���������", "������15����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "�����", "�Ҿư�", "������ ����", "����������� 5����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "�����", "�����ܰ�", "�Ѿ������", "�Ѿ�뺴�� 15����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "�Ŵ���", "�Ȱ�", "����� ����", "������ 1����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "�迵��", "����", "�Ǳ��� ����", "�Ǵ뺴�� 5����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "������", "�ܰ�", "����� ����", "������ 10����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "���켺", "�Ҿư�", "������ ����", "�� ���� 30����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "�ձ⿵", "�����ܰ�", "�Ѿ�� ����", "������ 10����");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "��ȫ��", "�Ȱ�", "�Ǳ��� ����", "�Ǵ뺴��5�� ���");
	
	
	}
	
	
	
	//������
	public void CustomerInfo() {
		System.out.println("��������������������������������������");
		System.out.println("�����Ͻô� �޴��� �����ϼ��䦢");
		System.out.println("��1. �������ȭ��ȣ ���榢");
		System.out.println("��2. ����ȣ �н�            ��");
		System.out.println("��������������������������������������");
		System.out.print(">>");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			updateClients();
			break;
			
		case 2: 
			searchClientNumber(); 
			break;
		}
		
		
	}
	
	// �� ���� ����. (�޴��� ��ȣ)
	public boolean updateClients() {
		boolean flag = false;  
		
		System.out.println("[ �� ��� ��ȭ��ȣ�� ���� �޴�.]");
		System.out.print("�� �̸��Է� :");
		clname = scLine.nextLine();
		System.out.print("�� �ֹι�ȣ �Է� : ");
		clpn = scLine.nextLine(); 
		
		Clients vo = new Clients(clname, clpn);
		
		
		if(hd.checkClientNumber(vo)) {
			flag = true;
			System.out.print("������ ���� �ڵ��� ��ȣ�� �Է� : ");
			clphone = scLine.nextLine(); 
			Clients vo2 = new Clients(clname, clpn, clphone);
			if(hd.updateClients(vo2)) {
				System.out.println("������ ������ ���������� �����Ǿ����ϴ�.");
			}else {
				System.out.println("** �����߻�. ");
			}
			
			
		}
		return false; 
	}

	public boolean searchClientNumber() {
		boolean flag = false; 
		
		System.out.println("[ �� ��ȣ ã�� ]");
		System.out.print("�� �ڵ��� ��ȣ �Է� : ");
		clphone = scLine.nextLine(); 
		 
		Clients vo = new Clients(clphone);
		if(hd.searchClientNumber(vo)) {
			flag = true; 
		}else {
			System.out.println("** �������� �ʴ� �ڵ��� ��ȣ�Դϴ�.");
		}
		
		return false; 
	}
	
	
}
