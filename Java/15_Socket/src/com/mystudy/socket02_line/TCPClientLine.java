package com.mystudy.socket02_line;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientLine {

	public static void main(String[] args) {
		// ������ �����ؼ� ���������� �޽��� ����
		System.out.println(">> Ŭ���̾�Ʈ ����");
		
		//0. ����� ����(Socket) ��ü ������ ���� ����
		Socket socket = null;
		
		try {
			System.out.println("������ǻ������ : " + InetAddress.getLocalHost());
			System.out.println(">> ������ ����~~~");
			//1. ���ϻ���(Socket) : ������ IP�ּ�, ��Ʈ(port) ������ ������ ����
			socket = new Socket(InetAddress.getLocalHost(), 10000);
			
			//2. �������� ���� in, out ����
			InputStream is = socket.getInputStream();
			
			OutputStream os = socket.getOutputStream();
			//OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(os);
			
			//3. ����(output)�� �����Ͱ� ������ ����(write)
			System.out.println(">> �޽��� ����");
			String msg = "�ȳ��ϼ���. ������ �ݰ����ϴ�. ������� ������~~~";
			System.out.println("[�����Ҹ޽���] : " + msg);
			pw.println(msg);
			
			pw.flush(); //���ۿ� �ִ� �����͸� ������ ���(����)
			
			//4. ����(input) �����Ͱ� ������ �б�(read)
			//(��������)
			
			pw.close();
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(">> Ŭ���̾�Ʈ ����");
	}

}
