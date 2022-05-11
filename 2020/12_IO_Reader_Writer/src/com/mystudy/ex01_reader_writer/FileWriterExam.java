package com.mystudy.ex01_reader_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExam {

	public static void main(String[] args) {
		// FileWriter : 파일에 문자단위 쓰기(출력)
		File file = new File("file/test_char_out.txt");

		//변수선언
		FileWriter fw = null;
		
		try {
			//객체 생성
			fw = new FileWriter(file);
			
			//객체 사용
			fw.write('대'); // char -> int : 자동형변환
			fw.write("한"); // String
			fw.write("민국");
			
			//버퍼(buffer) : 버퍼용량이 채워지면 자동으로 Output 처리
			//버퍼(buffer)가 채워지지 않았을 때 output 처리하려면 flush() 호출
			//close() 처리시에는 버퍼 데이터를 output 처리해줌
			fw.flush(); //버퍼(buffer)가 채워지지 않아도 Output 처리
			
			fw.write("Hello Java!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}













