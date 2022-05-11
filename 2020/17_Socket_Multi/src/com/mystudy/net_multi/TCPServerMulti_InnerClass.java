package com.mystudy.net_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMulti_InnerClass {

	public static void main(String[] args) {
		System.out.println("---- main() ���� ---");
		new TCPServerMulti_InnerClass();
		System.out.println("---- main() �� ---");
	}
	
	TCPServerMulti_InnerClass() {
		serverStart();
	}

	private void serverStart() {
		System.out.println(">>>>> ���� ���� ");
		ServerSocket server = null;
		try {
			System.out.println(">> �������� ��ü ����");
			server = new ServerSocket(10000);
			
			while (true) {
				System.out.println(">> ���� �����...");
				Socket socket = server.accept();
				System.out.println(">> Ŭ���̾�Ʈ ����");
				System.out.println(">> Ŭ���̾�Ʈ ���� ���� : "
						+ socket.getInetAddress());
				
				//���������� �����ؼ� ����� ó��(����Ŭ���� ���-������)
				SocketThread thr = new SocketThread(socket);
				thr.start(); //������� ���۽�Ű�� ���� start() ȣ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����Ŭ���� : ����(Socket)�� ���޹޾� �б�(Input) ���� ������ ���� Ŭ����
	// ���ӵ� Ŭ���̾�Ʈ�� ������ �޽��� �޾Ƽ� ȭ�� ���
	class SocketThread extends Thread {
		Socket socket;
		
		SocketThread(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			System.out.println(">>> ������ ���� : "
					+ socket.getInetAddress());
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			
			try {
				is = socket.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				
				System.out.println(">> �б����");
				
				while (true) {
					String msg = br.readLine();
					//������ ����ų� "exit" ���� ������ ����
					if (msg == null || "exit".equalsIgnoreCase(msg)) {
						break;
					}
					System.out.println(">>> " + msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println(">> Ŭ���̾�Ʈ ����");
				try {
					if (br != null) br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}









