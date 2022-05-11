package com.mystudy.ex02_filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest2_buffer_try_with {

	public static void main(String[] args) {
		// (�ǽ�)���� ��� ���Ϻ��� : byte ���� ���� ���� - 1byte �а� 1byte ���
		// FileInputStream, FileOutputStream
		// BufferedInputStream, BufferedOutputStream ���
		// input ���� : file/img_tea.jpg
		// output ���� : file/img_tea_copy_buffer.jpg
		//------------------------------------------
		File file = new File("file/img_tea.jpg");
		
		//���Ϸ� ���� byte ���� ó���� ��ü�� ������ ���� ����
		FileOutputStream fos = null;
		
		//���ۻ���� ���� ���� ���� �� ��ü����
		try (BufferedInputStream bis 
				= new BufferedInputStream(new FileInputStream(file), 10);
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("file/img_tea_copy_buffer.jpg"), 10);) {
			
			//���۽ð� Ȯ��
			long startTime = System.currentTimeMillis();
			
			//�����̿� �а�, ����
			int readValue = bis.read();
			while (readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			bos.flush();
			
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


























