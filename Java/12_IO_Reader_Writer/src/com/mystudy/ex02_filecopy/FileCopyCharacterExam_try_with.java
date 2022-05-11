package com.mystudy.ex02_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExam_try_with {

	public static void main(String[] args) {
		/* (실습) FileReader, FileWriter 사용해서 파일 복사
		원본파일 : file/test_char.txt
		대상파일 : file/test_char_copy.txt
		할일 : 원본파일을 읽어서 대상파일에 쓰기(저장 - 문자단위 처리) - 파일복사구현
		***************************/
		//0. 사용할 파일(File) 객체 생성
		File fileIn = new File("file/test_char.txt");
		File fileOut = new File("file/test_char_copy.txt");
		
		//1. 파일로 부터 읽고, 쓸 객체를 저장할 변수 선언 
		//2. 읽기위한 객체 생성, 쓰기위한 객체 생성
		try (FileReader fr = new FileReader(fileIn);
				FileWriter fw = new FileWriter(fileOut);) {
			
			//3. 읽고, 쓰기(반복작업) : 문자 1개 읽고, 읽은 문자 출력
			int readValue = fr.read();
			while (readValue != -1) {
				fw.write(readValue);
				readValue = fr.read();
			}
			fw.flush(); //버퍼 데이터 강제 출력
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}











