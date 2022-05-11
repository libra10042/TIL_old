package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputStream_list {

	public static void main(String[] args) {
		// 파일(file/object_io_list.txt)에 저장된 List 데이터를 읽어들여
		// List에 저장된 학생정보를 화면 출력(성명, 총점, 평균)
		// 화면출력예) 홍길동  271  90.33 
		//----------------------------------
		File file = new File("file/object_io_list.txt");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			List<StudentVO> list = (ArrayList<StudentVO>) ois.readObject();
			StudentVO vo = list.get(0);
			System.out.println(vo.getName() + "\t" + vo.getTot() + "\t" 
					+ vo.getAvg());
			
			System.out.println("--- List 전체 데이터 처리 ----");
			for (int i = 0; i < list.size(); i++) {
				StudentVO svo = list.get(i);
				System.out.println(svo.getName() + "\t" + svo.getAvg());
			}
			
			System.out.println("--- List 전체 데이터 처리(개선된 for) ---");
			StringBuilder sb = new StringBuilder();
			for (StudentVO svo : list) {
				sb.append(svo.getName());
				sb.append("\t");
				sb.append(svo.getAvg());
				
				System.out.println(sb.toString());
				sb.setLength(0);
			}
			
		} catch (IOException | ClassNotFoundException e) {
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














