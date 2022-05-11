package com.mystudy.ex02_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex4_try_with {

	public static void main(String[] args) {
		File file = new File("file/test_01.txt");
		
		//1. ��ü ����(���� �б��) <- File ��ü �Է¹���
		try (FileInputStream fis = new FileInputStream(file);) {
			
			//2. ��ü��� �۾� ó��(�б�)
			byte[] bytes = new byte[10];
			System.out.println("bytes : " + Arrays.toString(bytes));
			
			System.out.println("--- 1��° �б� ---");
			int byteCnt = 0;

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
		} 
	}

}










