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
		// Object 타입의 데이터를 사용해서 입/출력(I/O)
		//---------------------------------
		// Object 타입의 데이터를 파일에 쓰고(저장)하고 읽어오기
		// StudentVO 타입의 데이터 사용
		
		File file = new File("file/object_io.txt");
		//파일에 쓰기위한 용도
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		stu1.setPhone("010-1111-1111");
		StudentVO stu2 = new StudentVO("김유신", 100, 90, 81);
		stu2.setPhone("010-2222-2222");
		System.out.println(stu1);
		System.out.println(stu2);
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			//StudentVO 타입 데이터 출력
			System.out.println(">> 파일에 쓰기(ObjectOutputStream)");
			oos.writeObject(stu1);
			oos.writeObject(stu2);
			
			System.out.println(">> 파일에 쓰기 성공!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n====== 읽어오기(Input) =========");
		//=======================================
		//파일에 저장된 데이터 읽기
		//FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			System.out.println(">> 파일데이터 읽기(ObjectInputStream)");
			
			StudentVO inputStu1 = (StudentVO) ois.readObject();
			StudentVO inputStu2 = (StudentVO) ois.readObject();
			
			System.out.println(">> 읽어온 데이터 출력");
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












