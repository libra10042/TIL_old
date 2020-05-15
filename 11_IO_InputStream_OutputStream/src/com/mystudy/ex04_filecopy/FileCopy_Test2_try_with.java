package com.mystudy.ex04_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_Test2_try_with {

	public static void main(String[] args) {
		// 파일복사 : 원본파일에서 읽고(Input) 대상파일에 쓰기(Output)
		
		//복사할 원본 파일(Source file : AS-IS)
		File fileIn = new File("file/test_01.txt");
		//File fileIn = new File("바이트_InputStream.png");
		
		//쓰기 위한 대상 파일(target file : TO-BE)
		File fileOut = new File("file/test_01_copy.txt");
		//File fileOut = new File("file/바이트_InputStream_copy.png");
		
		//0. 파일에서 읽고 쓰기 위한 객체를 저장할 변수 선언
		//1. 파일에서 읽고 쓰기 위한 객체 생성
		//3. 사용객체 close(try~with문에서 자동 처리)
		try (FileInputStream fis = new FileInputStream(fileIn);
				FileOutputStream fos = new FileOutputStream(fileOut);) {
			
			//2. 객체 사용해서 작업처리(읽고 쓰기)
			int readValue = -1;
			
			while (true) {
				readValue = fis.read(); //1 byte 읽기
				if (readValue == -1) break; //EOF(End of File) 파일의 끝이면 반복종료
				fos.write(readValue); //1 byte 쓰기
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}













