package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClientEcho {
	public static void main(String[] args) {
		/* (�ǽ�) Ŭ���̾�Ʈ ����
		1. ���ϻ���ؼ� ������ ����
		2. ���Ͽ��� in, out ��ü ���� �� IO�۾��� ��ü ���� 
		3. ���������� �޽��� ����(����, Output)
		4. �����ʿ��� ������ �޽��� ����(�б�, Input)
			> ���� �޽��� ȭ�� ���
		*/
		Socket socket = null;
		
		//�����͸� �б� ���� ��ü�� ������ ���� ����
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		//�����͸� ���� ���� ��ü�� ������ ���� ����
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			System.out.println("------ Ŭ���̾�Ʈ ---------");
			//1. ���ϻ���ؼ� ������ ����
			socket = new Socket("localhost", 10000);
			System.out.println(">>> ���� ���� �Ϸ�");
			
			//2. ���Ͽ��� in, out ��ü ���� �� IO�۾��� ��ü ���� 
			//3. ���������� �޽��� ����(����, Output)
			System.out.println(">> �޽��� ����(client -> server)");
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			
			String msg = "�ȳ��ϼ���~ �ݰ����ϴ�";
			pw.println(msg);
			pw.flush(); //���۵����� ���� ��� ó��
			System.out.println("> �����޽��� : " + msg);
			System.out.println(">> �޽��� ������ �Ϸ�");
			
			//4. �����ʿ��� ������ �޽��� ����(�б�, Input)
			//	> ���� �޽��� ȭ�� ���
			System.out.println(">> �޽��� �б�(client <- server)");
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String receiveMsg = br.readLine();
			System.out.println(">> �����޽��� : " + receiveMsg);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>> Ŭ���̾�Ʈ ����");
	}

}












