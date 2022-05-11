package com.mystudy.ex01_reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExam2 {

	public static void main(String[] args) {
		// ����(Character) ���� �Է�ó��
		// FileReader : ���Ϸκ��� ���ڴ����� ������ �б�
		// ���ڴ��� : 1, A, $ - 1 byte ����
		//         ��, ��, �K - 2 byte ����(�ѱ�, �߱���...)
		//-------------------------------
		
		// FileReader �� �о�� ��� ����(file)
		File file = new File("file/test_char.txt");
		
		// FileReader Ÿ�� ��ü(�ν��Ͻ�) ����� ���� ����
		FileReader fr = null;
		
		try {
			//1. ��ü ����
			fr = new FileReader(file);
			
			//2. ��ü�� ����ؼ� ���ڴ����� �б�
			//(�ǽ�) �ݺ��� ó��(��ü ������ �о ȭ�� ���)
			int readChar = -1;
/*			
			while (true) {
				readChar = fr.read();
				if (readChar == -1) break;
				System.out.print((char)readChar);
			}
*/			
			while ( (readChar = fr.read()) != -1) {
				System.out.print((char)readChar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. ��ü close
			try {
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}












