package com.mystudy.ex02_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex2 {

	public static void main(String[] args) {
		// 사용방식
		//1. 사용할 객체 생성(FileInputStream)
		//2. 객체사용해서 데이터 읽기
		//3. 사용 객체 닫기
		//---------------------
		File file = new File("file/test_01.txt");
		
		//사용할 객체 저장 변수 선언
		FileInputStream fis = null;
		
		try {
			//1. 사용할 객체 생성(FileInputStream)
			fis = new FileInputStream(file);
			System.out.println(">> 객체생성 완료");
			
			//2. 객체사용 데이터 읽기 처리
			int readValue = -1;
/*			
			while (true) {
				readValue = fis.read();
				if (readValue == -1) break;
				System.out.print("int값: " + readValue);
				System.out.println(", " + (char)readValue);
			}
*/			
			//readValue = fis.read() : 데이터 읽기
			//readValue != -1 : 읽은 값이 EOF가 아니면
			while ( (readValue = fis.read()) != -1 ) {
				System.out.print("int값: " + readValue);
				System.out.println(", " + (char)readValue);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(">> 작업대상 파일이 없습니다.");
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 객체 close
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(">> main() 끝 -----");
	}

}












