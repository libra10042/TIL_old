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
		System.out.println("┌────────────┐");
		System.out.println("│ [접수처입니다] │");
		System.out.println("│1.처음방문           │");
		System.out.println("│2.기존방문           │");
		System.out.println("└────────────┘");
		System.out.print(">>");
		choice = sc.nextInt(); 
		switch(choice) {
		case 1:
			// 고객명, 고객번호, 주민등록번호, 전화번호, 증상 입력 모두 다 입력 했다면 증상입력 창 출력
			insertClients();
			
			break;
			
		case 2:
			existsClients();
			
			break;
		}
	}
	// 1-1. 처음방문 고객 등록. 
	public boolean insertClients() {
		
		try {
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
				
				careCheck(); 
			}else {
				System.out.println("**Error 고객등록 오류입니다.");
				return flag; 
				
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag; 
	}
	
	// 1-2.기존 방문 고객 
	public boolean existsClients() {
		boolean flag = false; 
		System.out.print("고객님의 번호를 입력해주세요 : ");
		clnumber = sc.nextInt();
		
		Clients s = new Clients(clnumber);
		
		if(hd.existsClient(s)) {
			flag = true;
			System.out.println("[[진료예약을 시작합니다.]]" );
			System.out.print("증상을 입력해주세요 : ");
			sympton = scLine.nextLine(); 
			
			careCheck();
			
		}else {
			System.out.println("** 존재하지 않는 회원입니다.");
		}
		return false; 
		
		
	}
	
	
	
	
	// 고객 번호를 통해 예약이 가능하다.
	public void searchClients() {
		//환자번호 입력
		System.out.println("환자 번호를 입력하세요 :");
		clnumber= sc.nextInt(); 
		
		Clients c = new Clients(clnumber);
		
		
		
	}
	
	//1-2. 진료 선택
	public boolean careCheck() {
		boolean flag = false; 
		System.out.println("-----보기-----");
		System.out.println("1. 내과,    2. 외과,    3.소아과,    4.정형외과,    5.안과");
		System.out.print(">>");
		partnumber = sc.nextInt(); 
		
		Part p = new Part(partnumber); 
		if(dd.selectDoctor(p)) {
			flag = true; 
			System.out.println("[진료받을 담당의를 선택하세요]");
			System.out.print(">>");
			donumber = sc.nextInt(); 
			System.out.println("[예약시간을 선택해주세요]");
			selectDoctorDate(); 
			
		}else {
			System.out.println("** 다시 선택해주세요");
		}
		return flag; 
	}
	
	
	
	
	
	//1-4 예약 날짜 출력. 
	public void selectDoctorDate() {
		LocalDate localDate = null; 

		//Month month = localDate.getMonth(); 
		//System.out.println(month.getValue());
		
		//10시 5분 40초 표현. 
		//LocalTime time = LocalTime.of(10, 5, 40);
		
		
		for(int i=1; i<=7; i++) {
			LocalDate plusDays = localDate.plusDays(i);
			System.out.println(i + "." + plusDays.format(DateTimeFormatter.ISO_DATE));
		}
		
		for(int j=9; j<=17; j++) {
			LocalTime timeSchedule = LocalTime.of(j, 00);
			System.out.println(j + "." + timeSchedule.format(DateTimeFormatter.ISO_DATE));
		}
		
		
		
		//년, 월, 일 구하기
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
		System.out.println("┌─────────────────┐");
		System.out.println("│로그인 유형을 선택해주세요│");
		System.out.println("│1. 고객                         │");
		System.out.println("│2. 직원                         │");
		System.out.println("│3. 이전으로                   │");
		System.out.println("└─────────────────┘");
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
	
	

	
	
	//예약조회 및 예약 취소
	public void DoctorInfo() {
		
	}
	
	//의료진 소개
	public void DoctorIntroduce() {
		System.out.println("의료진 소개");
		System.out.printf("%-25s%-20s%-25s%-20s%n", "이름", "전공", "학력", "경력" );
		System.out.println("======================================================");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "이충진", "내과", "서울대 졸업", "세브란스병원10년 경력");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "김건희", "외과", "경희대졸업", "본병원15년차");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "심재용", "소아과", "연세대 졸업", "세브란스병원 5년경력");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "김춘옥", "정영외과", "한양대졸업", "한양대병원 15년경력");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "신다혜", "안과", "고려대 졸업", "본병원 1년차");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "김영식", "내과", "건국대 졸업", "건대병원 5년경력");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "박혜순", "외과", "서울대 졸업", "본병원 10년차");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "성우성", "소아과", "연세대 졸업", "본 병원 30년차");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "손기영", "정형외과", "한양대 졸업", "본병원 10년차");
		System.out.printf("%-20s%-20s%-20s%-20s%n", "조홍준", "안과", "건국대 졸업", "건대병원5년 경력");
	
	
	}
	
	
	
	//고객정보
	public void CustomerInfo() {
		System.out.println("┌─────────────────┐");
		System.out.println("│원하시는 메뉴를 선택하세요│");
		System.out.println("│1. 고객등록전화번호 변경│");
		System.out.println("│2. 고객번호 분실            │");
		System.out.println("└─────────────────┘");
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
	
	// 고객 정보 수정. (휴대폰 번호)
	public boolean updateClients() {
		boolean flag = false;  
		
		System.out.println("[ 고객 등록 전화번호를 수정 메뉴.]");
		System.out.print("고객 이름입력 :");
		clname = scLine.nextLine();
		System.out.print("고객 주민번호 입력 : ");
		clpn = scLine.nextLine(); 
		
		Clients vo = new Clients(clname, clpn);
		
		
		if(hd.checkClientNumber(vo)) {
			flag = true;
			System.out.print("수정할 고객의 핸드폰 번호를 입력 : ");
			clphone = scLine.nextLine(); 
			Clients vo2 = new Clients(clname, clpn, clphone);
			if(hd.updateClients(vo2)) {
				System.out.println("고객님의 정보가 정상적으로 수정되었습니다.");
			}else {
				System.out.println("** 에러발생. ");
			}
			
			
		}
		return false; 
	}

	public boolean searchClientNumber() {
		boolean flag = false; 
		
		System.out.println("[ 고객 번호 찾기 ]");
		System.out.print("고객 핸드폰 번호 입력 : ");
		clphone = scLine.nextLine(); 
		 
		Clients vo = new Clients(clphone);
		if(hd.searchClientNumber(vo)) {
			flag = true; 
		}else {
			System.out.println("** 존재하지 않는 핸드폰 번호입니다.");
		}
		
		return false; 
	}
	
	
}
