package com.mystudy.ex02_list_exam;

import java.util.ArrayList;

public class StudentManager {

	public static void main(String[] args) {
		/*  List를 사용한 성적 처리
		1. 3명의 학생데이타(성명,국어,영어,수학)를 
		   StudentVO 클래스를 이용해서 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		2. ArrayList 타입의 변수(list)에 저장하고
		3. list에 있는 데이타를 사용해서 화면출력
		     성명     국어   영어  수학    총점     평균
		   --------------------------
		     홍길동  100  90  81  270  90.33
		   ...
		************************************/
		/*
		1. 3명의 학생데이타(성명,국어,영어,수학)를 
		   StudentVO 클래스를 이용해서 만들고(저장하고)
		--------------------------------------- */
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		System.out.println("stu1 : " + stu1);
		stu1.printData();
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);
		stu2.printData();
		stu3.printData();
		
		//2. ArrayList 타입의 변수(list)에 저장하고
		ArrayList list = new ArrayList();
		list.add(stu1);
		list.add(stu2);
		//list.add(stu3);
		list.add(new StudentVO("김유신", 90, 87, 77));
		
		System.out.println("----- 데이터 출력 ---");
		//3. list에 있는 데이타를 사용해서 화면출력
		//Object obj = list.get(0); //리스트에 있는 첫번째 데이터
		//StudentVO vo1 = (StudentVO) obj;
		StudentVO vo = (StudentVO) list.get(0);
		vo.printData();
		
		vo = (StudentVO) list.get(1);
		vo.printData();
		
		vo = (StudentVO) list.get(2);
		vo.printData();
		
		System.out.println("------------");
		System.out.println("list : " + list);
		//List 안에 있는 데이터를 꺼내서 화면 출력 반복 처리
		for (int i = 0; i < list.size(); i++) {
			StudentVO svo = (StudentVO) list.get(i);
			svo.printData();
		}
		
		System.out.println("---- 개선된 for문 ---");
		// for (저장된데이터타입  변수 : 집합객체)
		for (Object obj : list) {
			StudentVO svo = (StudentVO) obj;
			svo.printData();
		}
		
		System.out.println("===== ArrayList<StudentVO> 사용 =======");
		//제너릭(Generic) 사용
		ArrayList<StudentVO> list2 = new ArrayList<StudentVO>();
		list2.add(stu1);
		list2.add(stu2);
		list2.add(stu3);
		
		StudentVO stu = list2.get(0);
		stu.printData();
		
		System.out.println("---- 데이터 출력(for) ----");
		for (int i = 0; i < list2.size(); i++) {
			//StudentVO svo = list2.get(i);
			//svo.printData();
			list2.get(i).printData();
		}
		
		System.out.println("---- 데이터 출력(개선된 for문) ----");
		for (StudentVO svo : list2 ) {
			String name = svo.getName();
			double avg = svo.getAvg();
			System.out.println(name + ", " + avg);
			//System.out.println(svo.getName() + ", " + svo.getAvg());
		}
	}

}
















