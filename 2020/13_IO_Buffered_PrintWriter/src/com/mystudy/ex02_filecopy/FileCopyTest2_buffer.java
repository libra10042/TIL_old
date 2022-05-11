package com.mystudy.ex02_filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest2_buffer {

	public static void main(String[] args) {
		// (실습)버퍼 사용 파일복사 : byte 단위 파일 복사 - 1byte 읽고 1byte 출력
		// FileInputStream, FileOutputStream
		// BufferedInputStream, BufferedOutputStream 사용
		// input 파일 : file/img_tea.jpg
		// output 파일 : file/img_tea_copy_buffer.jpg
		//------------------------------------------
		File file = new File("file/img_tea.jpg");
		
		//파일로 부터 byte 단위 처리할 객체를 저장할 변수 선언
		FileOutputStream fos = null;
		
		//버퍼사용을 위한 변수 선언
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		//버퍼사용 객체 생성
		try {
			//버퍼사용 읽기 객체 생성
			bis = new BufferedInputStream(new FileInputStream(file), 10);
			//버퍼사용 쓰기 객체 생성
			bos = new BufferedOutputStream(
					new FileOutputStream("file/img_tea_copy_buffer.jpg"), 10);
			
			//시작시간 확인
			long startTime = System.currentTimeMillis();
			
			//버퍼이용 읽고, 쓰기
			int readValue = bis.read();
			while (readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			bos.flush();
			
			//끝난시간 확인
			long endTime = System.currentTimeMillis(); //8766 밀리초
			System.out.println("경과시간(밀리초) : " + (endTime - startTime));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) bos.close();
				if (bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}


























