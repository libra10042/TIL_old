package com.mystudy.bean03;

import com.mystudy.bean02.Student;

public class StudentManager {

	public static void main(String[] args) {
		/* (�ǽ�) 3���� ���� ó�� (3�� ��ü ���� ��� �Ǵ� �迭���)
		ȫ�浿, ��100, 90, 81
		�̼���, 95, 88, 92
		������, 90, 86, 77
		=====================
		��� ȭ�����(�ǰ���)
		ȫ�浿   100  90   81   271   90.33
		�̼���   95   88   92   ???   ??.??
		������   90   86   77   ???   ??.??
		-------------------------- */
		StudentVO stu1 = new StudentVO("ȫ�浿", 100, 90, 81);
		StudentVO stu2 = new StudentVO("�̼���", 95, 88, 92);
		StudentVO stu3 = new StudentVO("������", 90, 86, 77);
		
		stu1.setKor(999);
		
		stu1.printData();
		stu2.printData();
		stu3.printData();
		
		System.out.println("======== �迭�� ���� ��� =======");
		int[] nums = new int[3];
		String[] str = new String[3];
		StudentVO[] students = new StudentVO[3];
		students[0] = new StudentVO("ȫ�浿", 100, 90, 81);
		students[1] = stu2;
		students[2] = stu3;
		System.out.println(stu1 + " vs " + students[0]);
		System.out.println(stu2 + " vs " + students[1]);
		
		System.out.println("------");
		students[0].printData();
		students[1].printData();
		students[2].printData();
		
		System.out.println("--- for�� ó�� ---");
		for (int i = 0; i < students.length; i++) {
			students[i].printData();
		}
		System.out.println("----------------");
		printDataAll(students);
		
	}
	static void printDataAll(StudentVO[] students) {
		for (StudentVO vo : students) {
			vo.printData();
		}
	}

}












