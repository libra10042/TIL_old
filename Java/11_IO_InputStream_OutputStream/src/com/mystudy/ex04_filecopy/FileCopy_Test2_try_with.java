package com.mystudy.ex04_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_Test2_try_with {

	public static void main(String[] args) {
		// ���Ϻ��� : �������Ͽ��� �а�(Input) ������Ͽ� ����(Output)
		
		//������ ���� ����(Source file : AS-IS)
		File fileIn = new File("file/test_01.txt");
		//File fileIn = new File("����Ʈ_InputStream.png");
		
		//���� ���� ��� ����(target file : TO-BE)
		File fileOut = new File("file/test_01_copy.txt");
		//File fileOut = new File("file/����Ʈ_InputStream_copy.png");
		
		//0. ���Ͽ��� �а� ���� ���� ��ü�� ������ ���� ����
		//1. ���Ͽ��� �а� ���� ���� ��ü ����
		//3. ��밴ü close(try~with������ �ڵ� ó��)
		try (FileInputStream fis = new FileInputStream(fileIn);
				FileOutputStream fos = new FileOutputStream(fileOut);) {
			
			//2. ��ü ����ؼ� �۾�ó��(�а� ����)
			int readValue = -1;
			
			while (true) {
				readValue = fis.read(); //1 byte �б�
				if (readValue == -1) break; //EOF(End of File) ������ ���̸� �ݺ�����
				fos.write(readValue); //1 byte ����
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}













