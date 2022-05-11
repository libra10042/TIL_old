package com.mystudy.ex01_random;

import java.util.Calendar;
import java.util.Random;

public class RandomExam3 {

	public static void main(String[] args) {
		// (�ǽ�) ���� ����� ������� �˾ƺ���(0~100)
		// Math.random(), Random ����ؼ� ������� �� �����
		// ������
		// 2020�� 5�� 8�� ����� �������(0~100)�� 77�Դϴ�
		//----------------------------------
		
		//��, ��, �� ���ϱ�
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1; //0~11
		int date = calendar.get(Calendar.DATE);
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("date: " + date);
		String yyyymmdd = year + "�� " + month + "�� " + date + "��";

		int result = 0;
		//�ǽ�1 - Random nextInt(����)
		Random ran = new Random();
		result = ran.nextInt(101); //0~100 
		System.out.println(yyyymmdd + " ����� �������(0~100)�� "
				+ result + "�Դϴ�.");
		
		//�ǽ�2 - Math.random()
		result = (int)(Math.random() * 101);
		System.out.println(yyyymmdd + " ����� �������(0~100)�� "
				+ result + "�Դϴ�.");
		
		//(����) Random nextInt() : Math.abs() - ���밪
		result = Math.abs(ran.nextInt()) % 101;
		System.out.println(yyyymmdd + " ����� �������(0~100)�� "
				+ result + "�Դϴ�.");
	}

}










