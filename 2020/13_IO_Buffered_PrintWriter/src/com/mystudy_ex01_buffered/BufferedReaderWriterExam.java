package com.mystudy_ex01_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExam {

	public static void main(String[] args) {
		// ����(buffer) ����� �����Ǿ� �ִ� Ŭ����
		// BufferedReader, BufferedWriter
		// File --> FileReader --> BufferedReader
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		
		try {
			//�б� ���� ��� ���ϰ�ü ����
			File inFile = new File("file/test_buf_rw_in.txt");
			
			// ���Ϸ� ���� ���ڴ��� �б����� ��ü ����
			fr = new FileReader(inFile);
			
			// ���ۻ�� + �����б� ��� ��� ��ü ����
			bufferedReader = new BufferedReader(fr, 1000);
			
			//-----------------------------
			//���Ͽ� ���� ���� ��ü ����
			File outFile = new File("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile);
			bufferedWriter = new BufferedWriter(fw, 1000); //���۱�� + ���Ͼ��� ���
			
			bufferedWriter.write("�ȳ��ϼ���. �ڹٰ�����\n");
			bufferedWriter.write("Hello Java!!!");
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.write("����ֳ���??????");
			bufferedWriter.newLine();
			bufferedWriter.write("---------------");
			bufferedWriter.newLine();
			
			bufferedWriter.flush();
			
			//==============================
			//���Ϸ� ���� �а� ����(���۱�� �̿��ؼ�)
			String str = bufferedReader.readLine(); //1 ���� �б�
			System.out.println("readLine() ó�� ���� ��: " + str);
			
			//���Ͽ� ����(�� �� ����)
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			
			//���� ������ ��� �а� ����
			str = bufferedReader.readLine(); //���̻� ������ null ����
			while (str != null) {
				bufferedWriter.write(str); //����
				bufferedWriter.newLine(); //�ٹٲ�
				str = bufferedReader.readLine(); //�б�
			}
			
			bufferedWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//��밴ü close
			try {
				if (bufferedWriter != null) bufferedWriter.close();
				if (bufferedReader != null) bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}











