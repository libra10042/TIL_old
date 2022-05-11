package com.mystudy.ex03_isr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderExam {

	public static void main(String[] args) {
		//InputStreamReader : byte 처리 계열 --> 문자 처리 계열 전환
		//데이터를 byte계열로 읽어들이고, 최종적으로 문자단위 처리
		//InputStreamReader : InputStream --> Reader 전환
		//OutputStreamWriter : OutputStream --> Writer 전환
		//--------------------------------
		
		File file = new File("file/test_isr.txt");
		FileInputStream fis = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(file);
			
//			int readByte = fis.read();
//			System.out.println((char)readByte);
//			readByte = fis.read();
//			System.out.println((char)readByte); //문자 깨짐
			
			isr = new InputStreamReader(fis);
			int readIsr = isr.read();
			System.out.println((char)readIsr);
			readIsr = isr.read();
			System.out.println((char)readIsr);
			
			//버퍼기능 사용해서 읽기(라인단위)
			br = new BufferedReader(isr);
			String str = br.readLine(); //라인단위 읽기
			System.out.println(str);
			
			while (true) {
				str = br.readLine(); //라인단위 읽기
				if (str == null) break;
				System.out.println(str);
			}
			
		} catch (IOException e) {
			System.out.println("[예외발생] 파일을 읽다가 오류가 발생했습니다.");
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}































