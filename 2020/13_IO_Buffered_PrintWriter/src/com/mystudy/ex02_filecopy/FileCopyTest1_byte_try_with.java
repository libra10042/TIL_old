package com.mystudy.ex02_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest1_byte_try_with {

	public static void main(String[] args) {
		// (�ǽ�)���Ϻ��� : byte ���� ���� ���� - 1byte �а� 1byte ���
		// FileInputStream, FileOutputStream ���
		// input ���� : file/img_tea.jpg
		// output ���� : file/img_tea_copy_byte.jpg
		//------------------------------------------
		File file = new File("file/img_tea.jpg");
		
		//���Ϸ� ���� byte ���� ó���� ��ü�� ������ ���� ���� �� ��ü����
		try (FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos 
				=new FileOutputStream("file/img_tea_copy_byte.jpg");) {
			//���۽ð� Ȯ��
			long startTime = System.currentTimeMillis();
			
			//������ �а�, ����
			int readValue; 
			while ((readValue = fis.read()) != -1) {
				fos.write(readValue); //����
			}
			
			//�����ð� Ȯ��
			long endTime = System.currentTimeMillis(); //8766 �и���
			System.out.println("����ð�(�и���) : " + (endTime - startTime));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}











