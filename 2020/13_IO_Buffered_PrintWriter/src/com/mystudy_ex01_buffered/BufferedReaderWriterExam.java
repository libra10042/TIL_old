package com.mystudy_ex01_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExam {

	public static void main(String[] args) {
		// 버퍼(buffer) 기능이 구현되어 있는 클래스
		// BufferedReader, BufferedWriter
		// File --> FileReader --> BufferedReader
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		
		try {
			//읽기 위한 대상 파일객체 생성
			File inFile = new File("file/test_buf_rw_in.txt");
			
			// 파일로 부터 문자단위 읽기위한 객체 생성
			fr = new FileReader(inFile);
			
			// 버퍼사용 + 파일읽기 기능 사용 객체 생성
			bufferedReader = new BufferedReader(fr, 1000);
			
			//-----------------------------
			//파일에 쓰기 위한 객체 생성
			File outFile = new File("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile);
			bufferedWriter = new BufferedWriter(fw, 1000); //버퍼기능 + 파일쓰기 기능
			
			bufferedWriter.write("안녕하세요. 자바공부중\n");
			bufferedWriter.write("Hello Java!!!");
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.write("재미있나요??????");
			bufferedWriter.newLine();
			bufferedWriter.write("---------------");
			bufferedWriter.newLine();
			
			bufferedWriter.flush();
			
			//==============================
			//파일로 부터 읽고 쓰기(버퍼기능 이용해서)
			String str = bufferedReader.readLine(); //1 라인 읽기
			System.out.println("readLine() 처음 읽은 값: " + str);
			
			//파일에 쓰기(한 번 쓰기)
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			
			//남은 데이터 모두 읽고 쓰기
			str = bufferedReader.readLine(); //더이상 없으면 null 리턴
			while (str != null) {
				bufferedWriter.write(str); //쓰기
				bufferedWriter.newLine(); //줄바꿈
				str = bufferedReader.readLine(); //읽기
			}
			
			bufferedWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//사용객체 close
			try {
				if (bufferedWriter != null) bufferedWriter.close();
				if (bufferedReader != null) bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}











