package com.mystudy.socket01_byte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientByte {

	public static void main(String[] args) {
		//Ŭ���̾�Ʈ : Socket �̿��ؼ� ������ ����(����IP�ּ�, ������Ʈ��ȣ)
		Socket socket = null;
		
		try {
			System.out.println("--- Ŭ���̾�Ʈ ----");
			// localhost : ������ǻ��, 127�����ϴ� IP
			//socket = new Socket("localhost", 10000);
			socket = new Socket("127.0.0.1", 10000);
			System.out.println(">> ���� ���� ����~~~");
			
			//������ ���Ͽ��� Input, Output ��Ʈ�� ��ü ���� 
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//OutputStream �̿��ؼ� ���������� ����(���, ������, ����...)
//			os.write('A'); //���������� ���� 'A' ������
			
			byte[] buf = "�ȳ��ϼ���~ �ݰ����ϴ�.".getBytes();
			os.write(buf);
			
			os.close();
			is.close();
			System.out.println(">>>> Ŭ���̾�Ʈ ����");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}










