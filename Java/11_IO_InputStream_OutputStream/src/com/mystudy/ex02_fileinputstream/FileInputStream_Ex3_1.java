package com.mystudy.ex02_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3_1 {

	public static void main(String[] args) {
		File file = new File("file/test_01.txt");
		FileInputStream fis = null;
		
		try {
			//1. ��ü ����(���� �б��) <- File ��ü �Է¹���
			fis = new FileInputStream(file);
			
			//2. ��ü��� �۾� ó��(�б�)
			byte[] bytes = new byte[10];
			System.out.println("bytes : " + Arrays.toString(bytes));
			
			
			System.out.println("--- 1��° �б� ---");
			int byteCnt = fis.read(bytes); //���ϰ� : ������ ���� ����
			System.out.println("byteCnt : " + byteCnt);
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < byteCnt; i++) {
				System.out.println("���� : " + bytes[i]
						+ ", char : " + (char)bytes[i]);
			}
			System.out.println("--- 2��° �б� ---");
			byteCnt = fis.read(bytes);
			System.out.println("byteCnt : " + byteCnt);
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < byteCnt; i++) {
				System.out.println("���� : " + bytes[i]
						+ ", char : " + (char)bytes[i]);
			}
			
			System.out.println("--- 3��° �б� ---");
			byteCnt = fis.read(bytes);
			System.out.println("byteCnt : " + byteCnt);
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < byteCnt; i++) {
				System.out.println("���� : " + bytes[i]
						+ ", char : " + (char)bytes[i]);
			}
			
			System.out.println("--- 4��° �б� ---");
			byteCnt = fis.read(bytes);
			System.out.println("byteCnt : " + byteCnt);
			System.out.println("bytes : " + Arrays.toString(bytes));
			for (int i = 0; i < byteCnt; i++) {
				System.out.println("���� : " + bytes[i]
						+ ", char : " + (char)bytes[i]);
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










