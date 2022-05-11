package com.mystudy.ex04_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_Test {

	public static void main(String[] args) {
		// 파일복사 : 원본파일에서 읽고(Input) 대상파일에 쓰기(Output)
		
		//복사할 원본 파일(Source file : AS-IS)
		File fileIn = new File("file/test_01.txt");
		//File fileIn = new File("바이트_InputStream.png");
		
		//쓰기 위한 대상 파일(target file : TO-BE)
		File fileOut = new File("file/test_01_copy.txt");
		//File fileOut = new File("file/바이트_InputStream_copy.png");
		
		//0. 파일에서 읽고 쓰기 위한 객체를 저장할 변수 선언
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//1. 파일에서 읽고 쓰기 위한 객체 생성
			fis = new FileInputStream(fileIn);
			fos = new FileOutputStream(fileOut);
			
			//2. 객체 사용해서 작업처리(읽고 쓰기)
			int readValue = -1;
			
			while (true) {
				readValue = fis.read(); //1 byte 읽기
				if (readValue == -1) break; //EOF(End of File) 파일의 끝이면 반복종료
				fos.write(readValue); //1 byte 쓰기
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 close(생성순서 역순으로)
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}













