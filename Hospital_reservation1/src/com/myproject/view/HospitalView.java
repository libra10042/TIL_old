package com.myproject.view;

import java.util.Date;
import java.util.Scanner;

import com.myproject.dao.HospitalDao;
import com.myproject.vo.Clients;

public class HospitalView {
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private int choice; 
	private String clname, clpn, clphone, doname, password, info_doctor, partname; 
	private String sympton;
	private int renumber, clnumber, donumber, partnumber;
	private Date schedule;
	private HospitalDao hd = new HospitalDao(); 
	
	
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
	
	
	
	//---------------------------------------1. 진료 예약 -------------------------------------------
	public void Home() {
		System.out.println("┌────────────────────┐");
		System.out.println("│1. 진료예약하기                    │");
		System.out.println("│2. 예약조회 및 예약 취소        │" );
		System.out.println("│3. 의료진 소개                      │");
		System.out.println("│4. 고객정보                          │");
		System.out.println("│5. 종료                                │");
		System.out.println("└────────────────────┘");
		System.out.print(">>");
	}
	
	
	
	
	
	//1-1. 진료예약   
	public void visitView() {
		System.out.println("┌───────────┐");
		System.out.println("│ [접수처입니다]│");
		System.out.println("│1.처음방문        │");
		System.out.println("│2.기존방문        │");
		System.out.println("└───────────┘");
		System.out.println(">>");
		choice = sc.nextInt(); 
		switch(choice) {
		case 1:
			// 고객명, 고객번호, 주민등록번호, 전화번호, 증상 입력 모두 다 입력 했다면 증상입력 창 출력
			insertClients(); 
			
			
			
			
			break;
			
		case 2:
			//환자번호 입력
			System.out.println("환자 번호를 입력하세요 :");
			
			
			break;
		}
	}
	// 1. 처음방문 고객 등록. 
	public boolean insertClients() {
		flag = false; 
		System.out.println("진료 예약을 위한 필수정보를 입력합니다.");
		System.out.print("고객 이름 입력 : ");
		clname = scLine.nextLine(); 
		System.out.print("고객 주민번호 입력 : ");
		clpn = scLine.nextLine(); 
		System.out.print("고객 전화번호 입력 : ");
		clphone = scLine.nextLine(); 
		
		Clients s = new Clients(clname, clpn, clphone);
		
		if(hd.insertClients(s)) {
			flag = true;
			System.out.println(">>고객 등록이 완료되었습니다.");
			System.out.print("증상을 입력해주세요 : ");
			sympton = scLine.nextLine(); 
			
			
		}else {
			System.out.println("**Error 고객등록 오류입니다.");
			return flag; 
			
		}
		return flag; 
		
	}
	
	
	
	
	//1-2. 진료 선택
	public void careCheck() {
		System.out.println("-----보기-----");
		System.out.println("1. 내과,    2. 외과,    3.소아과,    4.정형외과,    5.안과");
		System.out.print(">>");
		choice = sc.nextInt(); 
		scLine.nextLine(); 
		switch(choice) {
		// 과를 선택하면 과에서 일하고 계시는 선생님들을 선택할 수 있다. 예약 날자를 선택한다. 예약날짜를 선택하면 예약신청이 완료된다. 
		case 1:
			
			break;
			
		case 2:
			break;
		
		}
		
	}
	
	
	public void reserveAndCancel() {
		System.out.println("┌─────────────────┐");
		System.out.println("│로그인 유형을 선택해주세요│");
		System.out.println("│1. 고객                         │");
		System.out.println("│2. 직원                         │");
		System.out.println("│3. 이전으로                   │");
		System.out.println("└─────────────────┘");
		System.out.print(">>");
		scLine.nextLine(); 
	}
	
	
	
	
	//예약조회 및 예약 취소
	public void DoctorInfo() {
		
	}
	
	//의료진 소개
	public void DoctorIntroduce() {
		System.out.println("의료진 소개");
		System.out.printf("%-20s%-25s%-20s%-25s%-20s%n", "번호", "이름", "전공", "학력", "경력" );
		System.out.println("======================================================");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "1", "이충진", "내과", "서울대 졸업", "세브란스병원10년 경력");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "2", "김건희", "외과", "경희대졸업", "본병원15년차");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "3", "심재용", "소아과", "연세대 졸업", "세브란스병원 5년경력");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "4", "김춘옥", "정영외과", "한양대졸업", "한양대병원 15년경력");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "5", "신다혜", "안과", "고려대 졸업", "본병원 1년차");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "6", "김영식", "내과", "건국대 졸업", "건대병원 5년경력");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "7", "박혜순", "외과", "서울대 졸업", "본병원 10년차");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "8", "성우성", "소아과", "연세대 졸업", "본 병원 30년차");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "9", "손기영", "정형외과", "한양대 졸업", "본병원 10년차");
		System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "10", "조홍준", "안과", "건국대 졸업", "건대병원5년 경력");
		
	
	}
	
	
	
	//고객정보
	public void CustomerInfo() {
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("1. 고객등록전화번호 변경");
		System.out.println("2. 고객번호 분실");
		
	}
	
	


	
	
}
