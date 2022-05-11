package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectOutputStream_list {

	public static void main(String[] args) {
		// StudentVO 객체들을 List에 담아서 파일에 저장
		System.out.println(">> 저장할 데이터 만들기");
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("김유신", 95, 85, 75);
		StudentVO stu3 = new StudentVO("강감찬", 99, 88, 77);
		System.out.println("stu1 : " + stu1);
		System.out.println("stu2 : " + stu2);
		System.out.println("stu3 : " + stu3);
		System.out.println("=======================");
		
		System.out.println("--- List에 담기 ---");
		ArrayList<StudentVO> list = new ArrayList<>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		System.out.println("list : " + list);
		System.out.println("==============================");
		
		//(실습) List에 담긴 데이터를 파일에 저장
		// 저장할 파일명: file/object_io_list.txt
		// FileOutputStream, ObjectOutputStream 사용
		//------------------------------
		
		//File -> FileOutputStream -> ObjectOutputStream
		File file = new File("file/object_io_list.txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos); //Object 타입 출력
			oos.writeObject(list); // list 출력 : list 안에 있는 vo 모두 출력
			
			System.out.println(">> 파일 출력 완료");
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












