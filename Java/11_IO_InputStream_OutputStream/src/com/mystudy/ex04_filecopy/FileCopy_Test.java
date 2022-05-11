package com.mystudy.ex04_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy_Test {

	public static void main(String[] args) {
		// ���Ϻ��� : �������Ͽ��� �а�(Input) ������Ͽ� ����(Output)
		
		//������ ���� ����(Source file : AS-IS)
		File fileIn = new File("file/test_01.txt");
		//File fileIn = new File("����Ʈ_InputStream.png");
		
		//���� ���� ��� ����(target file : TO-BE)
		File fileOut = new File("file/test_01_copy.txt");
		//File fileOut = new File("file/����Ʈ_InputStream_copy.png");
		
		//0. ���Ͽ��� �а� ���� ���� ��ü�� ������ ���� ����
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//1. ���Ͽ��� �а� ���� ���� ��ü ����
			fis = new FileInputStream(fileIn);
			fos = new FileOutputStream(fileOut);
			
			//2. ��ü ����ؼ� �۾�ó��(�а� ����)
			int readValue = -1;
			
			while (true) {
				readValue = fis.read(); //1 byte �б�
				if (readValue == -1) break; //EOF(End of File) ������ ���̸� �ݺ�����
				fos.write(readValue); //1 byte ����
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. ��밴ü close(�������� ��������)
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}













