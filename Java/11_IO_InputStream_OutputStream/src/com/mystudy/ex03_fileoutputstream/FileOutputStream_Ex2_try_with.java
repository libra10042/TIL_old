package com.mystudy.ex03_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Ex2_try_with {

	public static void main(String[] args) {
		// FileOutputStream : byte 단위로 파일에 저장(출력, 쓰기)
		//     OutputStream 추상 클래스를 상속받아(확장해서 extends) 만들어진 클래스
		File file = new File("file/test_out_01.txt");
		
		//1. 객체 생성  //3. 객체 close
		try (FileOutputStream fos = new FileOutputStream(file);) {
			
			//2. 객체사용 작업 처리(출력)
			fos.write('H');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');
			fos.write('~');
			
			byte[] bytes = "Hello Java!!!".getBytes();
			for (int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
			
			//바이트 배열 값을 한 번에 출력
			fos.write(bytes);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}







