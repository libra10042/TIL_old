package com.mystudy.ex01_scanner;

import java.util.Scanner;

public class ScannerExam3_Scissors {

	public static void main(String[] args) {
		/* Scanner를 이용한 가위, 바위, 보 게임
		컴퓨터와 함께 가위, 바위, 보 게임
		0. 컴퓨터가 가위, 바위, 보를 선택(Math.random())
		1. 1.가위     2.바위    3.보     0.종료   선택메뉴 사용
		2. 사람이 선택 값 입력
		3. 결과 확인 후 승자, 패자 결정해서 출력
		(반복) 게임 반복 진행 여부 - 0 선택시 종료
		************************* */
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			//0. 컴퓨터가 가위, 바위, 보를 선택(Math.random())
			int comSelect = (int)(Math.random() * 3 + 1);
			comSelect = 3;
			System.out.println("컴퓨터가 선택한 숫자 : " + comSelect);
			
			//1. 1.가위     2.바위    3.보     0.종료   선택메뉴 사용
			System.out.println("1.가위     2.바위    3.보     0.종료 ");
			System.out.print(">>당신의 선택은(1~3)? ");
			int select = Integer.parseInt(scan.nextLine());
			
			String strComputer = "";
			if (comSelect == 1) {
				strComputer = "가위";
			} else if (comSelect == 2) {
				strComputer = "바위";
			} else if (comSelect == 3) {
				strComputer = "보";
			} else {
				System.out.println("1~3중에 하나를 선택해야 합니다.");
			}
			System.out.println("컴퓨터의 선택 : " + strComputer);
			
			String strPerson = "";
			switch (select) {
			case 1 :
				strPerson = "가위"; break;
			case 2 :
				strPerson = "바위"; break;
			case 3 :
				strPerson = "보"; break;
			default : 
				System.out.println("1~3중에 하나를 선택해야 합니다.");
			}
			
			System.out.println("--------------");
			System.out.println("컴퓨터의 선택 : " + strComputer);
			System.out.println("나의 선택 : " + strPerson);
			
			//3. 결과 확인 후 승자, 패자 결정해서 출력
			//사람이 "가위"인 경우
			String result = "";
			final String COM_WIN = "컴퓨터가 이겼다";
			if (strPerson.equals("가위")) {
				if (strComputer.equals("가위")) {
					result = "무승부";
				}
				if (strComputer.equals("바위")) {
					result = COM_WIN;
				}
				if (strComputer.equals("보")) {
					result = "내가 이겼다!!";
				}
			}
			
			//사람이 "바위"인 경우
			if (strPerson.equals("바위")) {
				if (strComputer.equals("가위")) {
					result = "내가 이겼다!!";
				}
				if (strComputer.equals("바위")) {
					result = "무승부";
				}
				if (strComputer.equals("보")) {
					result = COM_WIN;
				}
			}
			
			//사람이 "보"인 경우
			if (strPerson.equals("보")) {
				if (strComputer.equals("가위")) {
					result = COM_WIN;
				}
				if (strComputer.equals("바위")) {
					result = "내가 이겼다!!";
				}
				if (strComputer.equals("보")) {
					result = "무승부";
				}
			}
			
			//결과 출력
			System.out.println("---- 결과 ---");
			System.out.println(">>> " + result);
			
			System.out.println();
			System.out.print(">> 한 번 더 할래(y:계속, n:중단)? ");
			String oneMore = scan.nextLine();
			if (oneMore.equalsIgnoreCase("n")) {
				System.out.println(">> 게임을 중단합니다");
				break;
			}
		}
	}

}



















