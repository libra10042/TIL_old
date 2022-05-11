package com.mystudy.ex01_reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExam1 {

	public static void main(String[] args) {
		// 문자(Character) 단위 입력처리
		// FileReader : 파일로부터 문자단위로 데이터 읽기
		// 문자단위 : 1, A, $ - 1 byte 문자
		//         대, 한, 핳 - 2 byte 문자(한글, 중국어...)
		//-------------------------------
		
		// FileReader 로 읽어올 대상 지정(file)
		File file = new File("file/test_char.txt");
		
		// FileReader 타입 객체(인스턴스) 저장용 변수 선언
		FileReader fr = null;
		
		try {
			//1. 객체 생성
			fr = new FileReader(file);
			
			//2. 객체를 사용해서 문자단위로 읽기
			int readChar = fr.read();
			System.out.println("첫번째 문자(int): " + readChar
					+ ", char: " + (char)readChar);
			
			readChar = fr.read();
			System.out.println("두번째 문자(int): " + readChar
					+ ", char: " + (char)readChar);
			
			readChar = fr.read();
			System.out.println("세번째 문자(int): " + readChar
					+ ", char: " + (char)readChar);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 객체 close
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}












