package com.mystudy.ex02_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
InputStream : 바이트단위 입력처리용 추상(abstract) 클래스
FileInputStream : InputStream을 상속받아(extends) 만든 클래스
	파일(file)로 부터 데이터를 입력(읽어) 처리하기 위한 클래스
	바이트(byte) 단위 처리
*/
public class FileInputStream_Ex1 {

	public static void main(String[] args) {
		File file = new File("temp.txt");
		if (!file.exists()) { //파일이 없으면 새로 만들기
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileInputStream fis = null;
		try {
			//1. FileInputStream 객체 생성
			//	 FileNotFoundException 예외발생 가능성 있음
			fis = new FileInputStream(file);
			
			//2. 객체 사용 : 데이터 읽기
			int readValue = fis.read(); //IOException
			System.out.println("fis.read() 값(int) : " + readValue);
			System.out.println("fis.read() char : " + (char)readValue);
			
			System.out.println("--- 전체 데이터 읽어오기 ---");
			while (true) {
				readValue = fis.read();
				if (readValue == -1) break; //EOF(End of File) 만나면 -1 리턴
				System.out.print("int 값 : " + readValue);
				System.out.println(", char 문자 : " + (char)readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기 : 사용자원 원위치(파일 close)
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(">> main() 끝---");
	}

}





















