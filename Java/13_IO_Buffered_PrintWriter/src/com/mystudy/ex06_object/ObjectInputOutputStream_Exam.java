package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream_Exam {

	public static void main(String[] args) {
		// ObjectInputStream, ObjectOutputStream 
		// Object Ÿ���� �����͸� ����ؼ� ��/���(I/O)
		//---------------------------------
		// Object Ÿ���� �����͸� ���Ͽ� ����(����)�ϰ� �о����
		// StudentVO Ÿ���� ������ ���
		
		File file = new File("file/object_io.txt");
		//���Ͽ� �������� �뵵
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		StudentVO stu1 = new StudentVO("ȫ�浿", 100, 90, 81);
		stu1.setPhone("010-1111-1111");
		StudentVO stu2 = new StudentVO("������", 100, 90, 81);
		stu2.setPhone("010-2222-2222");
		System.out.println(stu1);
		System.out.println(stu2);
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			//StudentVO Ÿ�� ������ ���
			System.out.println(">> ���Ͽ� ����(ObjectOutputStream)");
			oos.writeObject(stu1);
			oos.writeObject(stu2);
			
			System.out.println(">> ���Ͽ� ���� ����!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n====== �о����(Input) =========");
		//=======================================
		//���Ͽ� ����� ������ �б�
		//FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			System.out.println(">> ���ϵ����� �б�(ObjectInputStream)");
			
			StudentVO inputStu1 = (StudentVO) ois.readObject();
			StudentVO inputStu2 = (StudentVO) ois.readObject();
			
			System.out.println(">> �о�� ������ ���");
			System.out.println("inputStu1 : " + inputStu1);
			System.out.println("inputStu2 : " + inputStu2);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}












