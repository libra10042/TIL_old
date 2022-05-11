package com.mystudy.ex02_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex2 {

	public static void main(String[] args) {
		// �����
		//1. ����� ��ü ����(FileInputStream)
		//2. ��ü����ؼ� ������ �б�
		//3. ��� ��ü �ݱ�
		//---------------------
		File file = new File("file/test_01.txt");
		
		//����� ��ü ���� ���� ����
		FileInputStream fis = null;
		
		try {
			//1. ����� ��ü ����(FileInputStream)
			fis = new FileInputStream(file);
			System.out.println(">> ��ü���� �Ϸ�");
			
			//2. ��ü��� ������ �б� ó��
			int readValue = -1;
/*			
			while (true) {
				readValue = fis.read();
				if (readValue == -1) break;
				System.out.print("int��: " + readValue);
				System.out.println(", " + (char)readValue);
			}
*/			
			//readValue = fis.read() : ������ �б�
			//readValue != -1 : ���� ���� EOF�� �ƴϸ�
			while ( (readValue = fis.read()) != -1 ) {
				System.out.print("int��: " + readValue);
				System.out.println(", " + (char)readValue);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(">> �۾���� ������ �����ϴ�.");
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. ��ü close
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(">> main() �� -----");
	}

}












