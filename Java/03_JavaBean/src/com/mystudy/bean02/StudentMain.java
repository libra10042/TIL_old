package com.mystudy.bean02;

public class StudentMain {

	public static void main(String[] args) {
		// ȫ�浿, 100, 90, 80 �� ������ �̿� �Է��ϰ�
		// get�޼ҵ� �̿� ������ Ȯ��
		Student stu = new Student("ȫ�浿", 100, 90, 80);
		System.out.println("stu : " + stu);
		stu.setMath(85);
		stu.setEng(95);
		//stu.setAvg(100);
		stu.setKor(950);
		
//		stu.setTot(stu.getKor() + stu.getEng() + stu.getMath());
//		stu.setAvg(stu.getTot() * 100 / 3 / 100.0);
		System.out.println("stu : " + stu);
		
		System.out.println("==========================");
		// ������, 99, 88, 77 ��  �⺻������ ��� ��ü(�ν��Ͻ�) ����
		// set�޼ҵ� ����ؼ� ���� �Է��ϰ�, get�޼ҵ� ��� �Է°� Ȯ��

	}

}
