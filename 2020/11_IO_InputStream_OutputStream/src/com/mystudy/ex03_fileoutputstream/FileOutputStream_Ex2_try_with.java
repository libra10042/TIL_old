package com.mystudy.ex03_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Ex2_try_with {

	public static void main(String[] args) {
		// FileOutputStream : byte ������ ���Ͽ� ����(���, ����)
		//     OutputStream �߻� Ŭ������ ��ӹ޾�(Ȯ���ؼ� extends) ������� Ŭ����
		File file = new File("file/test_out_01.txt");
		
		//1. ��ü ����  //3. ��ü close
		try (FileOutputStream fos = new FileOutputStream(file);) {
			
			//2. ��ü��� �۾� ó��(���)
			fos.write('H');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');
			fos.write('~');
			
			byte[] bytes = "Hello Java!!!".getBytes();
			for (int i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
			
			//����Ʈ �迭 ���� �� ���� ���
			fos.write(bytes);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}







