package com.mystudy.ex02_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
InputStream : ����Ʈ���� �Է�ó���� �߻�(abstract) Ŭ����
FileInputStream : InputStream�� ��ӹ޾�(extends) ���� Ŭ����
	����(file)�� ���� �����͸� �Է�(�о�) ó���ϱ� ���� Ŭ����
	����Ʈ(byte) ���� ó��
*/
public class FileInputStream_Ex1 {

	public static void main(String[] args) {
		File file = new File("temp.txt");
		if (!file.exists()) { //������ ������ ���� �����
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileInputStream fis = null;
		try {
			//1. FileInputStream ��ü ����
			//	 FileNotFoundException ���ܹ߻� ���ɼ� ����
			fis = new FileInputStream(file);
			
			//2. ��ü ��� : ������ �б�
			int readValue = fis.read(); //IOException
			System.out.println("fis.read() ��(int) : " + readValue);
			System.out.println("fis.read() char : " + (char)readValue);
			
			System.out.println("--- ��ü ������ �о���� ---");
			while (true) {
				readValue = fis.read();
				if (readValue == -1) break; //EOF(End of File) ������ -1 ����
				System.out.print("int �� : " + readValue);
				System.out.println(", char ���� : " + (char)readValue);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. ��밴ü �ݱ� : ����ڿ� ����ġ(���� close)
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(">> main() ��---");
	}

}





















