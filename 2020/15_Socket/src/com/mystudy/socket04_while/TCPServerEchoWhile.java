package com.mystudy.socket04_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/* (�ǽ�) ������ ���� ����
1. �������� ����ؼ� Ŭ���̾�Ʈ ���� ���
2. Ŭ���̾�Ʈ �����ϸ� in, out ��ü ����
<�ݺ�ó��>
	3. Ŭ���̾�Ʈ�� ���� �޽��� �ް�(�б�, Input)
		> �����޽��� ȭ�����
	4. ���� �޽����� Ŭ���̾�Ʈ���� �ٽ� ����(����, Output)
		> �����޽��� ȭ�� ���
------
Ŭ���̾�Ʈ���� null�� �ްų� "exit" �޽��� ������ �ݺ� ���� ó��
*/
public class TCPServerEchoWhile {

	public static void main(String[] args) {
		ServerSocket server = null;
		
		//�����͸� �б� ���� ��ü�� ������ ���� ����
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		//�����͸� ���� ���� ��ü�� ������ ���� ����
		OutputStream os = null;
		PrintWriter pw = null;
		
		System.out.println(">>> ���� ����~~~");
		
		try {
			server = new ServerSocket(10000);
			System.out.println(">> Ŭ���̾�Ʈ ���� �����~~~");
			Socket socket = server.accept();
			
			//����� ���ϰ� �����͸� �ְ�ޱ� ���� I/O ��ü ����
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			//����Ʈ(byte) ó�� �迭�� ����(char) ó�� �迭�� ��ȯ
			isr = new InputStreamReader(is);
			
			//����(buffer) ������� ���ϰ� ���δ��� �Է�, ��� ��ü ����
			br = new BufferedReader(isr);
			pw = new PrintWriter(os);
			
			//================================
			//Ŭ���̾�Ʈ���� ���� ������ �а�, Ŭ���̾�Ʈ ������ ���� �ݺ�
			while (true) {
				System.out.println(">> ������ �б�");
				String msg = br.readLine();
				System.out.println("�����޽��� : " + msg);
				
				//Ŭ���̾�Ʈ�� ���� ���� �޽����� ���ų�(null)
				// exit�̸� ���� ó��
				if (msg == null || "exit".equalsIgnoreCase(msg)) {
					System.out.println(">> �����մϴ�");
					break;
				}
				System.out.println(">> ������ ������");
				pw.println(msg); //����
				pw.flush(); // ���� ������ ������
				System.out.println("�����޽��� : " + msg);
			}
			
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
				if (server != null) server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}













