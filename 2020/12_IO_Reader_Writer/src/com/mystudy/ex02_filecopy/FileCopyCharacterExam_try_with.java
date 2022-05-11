package com.mystudy.ex02_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExam_try_with {

	public static void main(String[] args) {
		/* (�ǽ�) FileReader, FileWriter ����ؼ� ���� ����
		�������� : file/test_char.txt
		������� : file/test_char_copy.txt
		���� : ���������� �о ������Ͽ� ����(���� - ���ڴ��� ó��) - ���Ϻ��籸��
		***************************/
		//0. ����� ����(File) ��ü ����
		File fileIn = new File("file/test_char.txt");
		File fileOut = new File("file/test_char_copy.txt");
		
		//1. ���Ϸ� ���� �а�, �� ��ü�� ������ ���� ���� 
		//2. �б����� ��ü ����, �������� ��ü ����
		try (FileReader fr = new FileReader(fileIn);
				FileWriter fw = new FileWriter(fileOut);) {
			
			//3. �а�, ����(�ݺ��۾�) : ���� 1�� �а�, ���� ���� ���
			int readValue = fr.read();
			while (readValue != -1) {
				fw.write(readValue);
				readValue = fr.read();
			}
			fw.flush(); //���� ������ ���� ���
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}











