package com.mystudy.ex01_reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExam2 {

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
			//(실습) 반복문 처리(전체 데이터 읽어서 화면 출력)
			int readChar = -1;
/*			
			while (true) {
				readChar = fr.read();
				if (readChar == -1) break;
				System.out.print((char)readChar);
			}
*/			
			while ( (readChar = fr.read()) != -1) {
				System.out.print((char)readChar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 객체 close
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}












