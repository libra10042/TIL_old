package com.mystudy.ex02_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest1_byte {

	public static void main(String[] args) {
		// (실습)파일복사 : byte 단위 파일 복사 - 1byte 읽고 1byte 출력
		// FileInputStream, FileOutputStream 사용
		// input 파일 : file/img_tea.jpg
		// output 파일 : file/img_tea_copy_byte.jpg
		//------------------------------------------
		File file = new File("file/img_tea.jpg");
		
		//파일로 부터 byte 단위 처리할 객체를 저장할 변수 선언
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//파일을 읽고, 쓰기위한 객체 생성
			fis = new FileInputStream(file);
			fos = new FileOutputStream("file/img_tea_copy_byte.jpg");
			
			//시작시간 확인
			long startTime = System.currentTimeMillis();
			
			//파일을 읽고, 쓰기
			int readValue; 
			while ((readValue = fis.read()) != -1) {
				fos.write(readValue); //쓰고
			}
			//끝난시간 확인
			long endTime = System.currentTimeMillis(); //8766 밀리초
			System.out.println("경과시간(밀리초) : " + (endTime - startTime));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) fos.close();
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}











