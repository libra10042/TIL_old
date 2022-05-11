package com.mystudy.ex02_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3_2 {

	public static void main(String[] args) {
		File file = new File("file/test_01.txt");
		FileInputStream fis = null;
		
		try {
			//1. ��ü ����(���� �б��) <- File ��ü �Է¹���
			//fis = new FileInputStream(file);
			fis = new FileInputStream("file/test_01.txt");
			
			//2. ��ü��� �۾� ó��(�б�)
			byte[] bytes = new byte[10];
			System.out.println("bytes : " + Arrays.toString(bytes));
			
			System.out.println("--- 1��° �б� ---");
			int byteCnt = 0;
/*			
			while (true) {
				byteCnt = fis.read(bytes);
				if (byteCnt == -1) break; //���� �����Ͱ� ������(EOF) -1 ����
				
				System.out.println("byteCnt : " + byteCnt);
				System.out.println("bytes : " + Arrays.toString(bytes));
				for (int i = 0; i < byteCnt; i++) {
					System.out.println("���� : " + bytes[i]
							+ ", char : " + (char)bytes[i]);
				}
			}
*/
			while ( (byteCnt = fis.read(bytes)) != -1) {
				System.out.println("byteCnt : " + byteCnt); //���� ������ �Ǽ�
				System.out.println("bytes : " + Arrays.toString(bytes));
				for (int i = 0; i < byteCnt; i++) {
					System.out.println("���� : " + bytes[i]
							+ ", char : " + (char)bytes[i]);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
	}

}










