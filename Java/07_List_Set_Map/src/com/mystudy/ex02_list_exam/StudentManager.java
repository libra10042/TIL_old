package com.mystudy.ex02_list_exam;

import java.util.ArrayList;

public class StudentManager {

	public static void main(String[] args) {
		/*  List�� ����� ���� ó��
		1. 3���� �л�����Ÿ(����,����,����,����)�� 
		   StudentVO Ŭ������ �̿��ؼ� �����(�����ϰ�)
		   "ȫ�浿", 100, 90, 81
		   "�̼���", 95, 88, 92
		   "������", 90, 87, 77
		2. ArrayList Ÿ���� ����(list)�� �����ϰ�
		3. list�� �ִ� ����Ÿ�� ����ؼ� ȭ�����
		     ����     ����   ����  ����    ����     ���
		   --------------------------
		     ȫ�浿  100  90  81  270  90.33
		   ...
		************************************/
		/*
		1. 3���� �л�����Ÿ(����,����,����,����)�� 
		   StudentVO Ŭ������ �̿��ؼ� �����(�����ϰ�)
		--------------------------------------- */
		StudentVO stu1 = new StudentVO("ȫ�浿", 100, 90, 81);
		System.out.println("stu1 : " + stu1);
		stu1.printData();
		StudentVO stu2 = new StudentVO("�̼���", 95, 88, 92);
		StudentVO stu3 = new StudentVO("������", 90, 87, 77);
		stu2.printData();
		stu3.printData();
		
		//2. ArrayList Ÿ���� ����(list)�� �����ϰ�
		ArrayList list = new ArrayList();
		list.add(stu1);
		list.add(stu2);
		//list.add(stu3);
		list.add(new StudentVO("������", 90, 87, 77));
		
		System.out.println("----- ������ ��� ---");
		//3. list�� �ִ� ����Ÿ�� ����ؼ� ȭ�����
		//Object obj = list.get(0); //����Ʈ�� �ִ� ù��° ������
		//StudentVO vo1 = (StudentVO) obj;
		StudentVO vo = (StudentVO) list.get(0);
		vo.printData();
		
		vo = (StudentVO) list.get(1);
		vo.printData();
		
		vo = (StudentVO) list.get(2);
		vo.printData();
		
		System.out.println("------------");
		System.out.println("list : " + list);
		//List �ȿ� �ִ� �����͸� ������ ȭ�� ��� �ݺ� ó��
		for (int i = 0; i < list.size(); i++) {
			StudentVO svo = (StudentVO) list.get(i);
			svo.printData();
		}
		
		System.out.println("---- ������ for�� ---");
		// for (����ȵ�����Ÿ��  ���� : ���հ�ü)
		for (Object obj : list) {
			StudentVO svo = (StudentVO) obj;
			svo.printData();
		}
		
		System.out.println("===== ArrayList<StudentVO> ��� =======");
		//���ʸ�(Generic) ���
		ArrayList<StudentVO> list2 = new ArrayList<StudentVO>();
		list2.add(stu1);
		list2.add(stu2);
		list2.add(stu3);
		
		StudentVO stu = list2.get(0);
		stu.printData();
		
		System.out.println("---- ������ ���(for) ----");
		for (int i = 0; i < list2.size(); i++) {
			//StudentVO svo = list2.get(i);
			//svo.printData();
			list2.get(i).printData();
		}
		
		System.out.println("---- ������ ���(������ for��) ----");
		for (StudentVO svo : list2 ) {
			String name = svo.getName();
			double avg = svo.getAvg();
			System.out.println(name + ", " + avg);
			//System.out.println(svo.getName() + ", " + svo.getAvg());
		}
	}

}
















