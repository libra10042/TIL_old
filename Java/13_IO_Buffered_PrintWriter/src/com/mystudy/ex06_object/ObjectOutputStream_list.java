package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectOutputStream_list {

	public static void main(String[] args) {
		// StudentVO ��ü���� List�� ��Ƽ� ���Ͽ� ����
		System.out.println(">> ������ ������ �����");
		StudentVO stu1 = new StudentVO("ȫ�浿", 100, 90, 81);
		StudentVO stu2 = new StudentVO("������", 95, 85, 75);
		StudentVO stu3 = new StudentVO("������", 99, 88, 77);
		System.out.println("stu1 : " + stu1);
		System.out.println("stu2 : " + stu2);
		System.out.println("stu3 : " + stu3);
		System.out.println("=======================");
		
		System.out.println("--- List�� ��� ---");
		ArrayList<StudentVO> list = new ArrayList<>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		System.out.println("list : " + list);
		System.out.println("==============================");
		
		//(�ǽ�) List�� ��� �����͸� ���Ͽ� ����
		// ������ ���ϸ�: file/object_io_list.txt
		// FileOutputStream, ObjectOutputStream ���
		//------------------------------
		
		//File -> FileOutputStream -> ObjectOutputStream
		File file = new File("file/object_io_list.txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos); //Object Ÿ�� ���
			oos.writeObject(list); // list ��� : list �ȿ� �ִ� vo ��� ���
			
			System.out.println(">> ���� ��� �Ϸ�");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}












