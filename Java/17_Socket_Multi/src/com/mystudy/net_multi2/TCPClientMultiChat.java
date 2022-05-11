package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// �޽��� �ۼ� ������ ���������� �����ϴ� ������ ����
// �޽��� ���� ���������� �����ϴ� ������ ����
public class TCPClientMultiChat {

	public static void main(String[] args) {
		// �۽�, ���� ������ �����ϰ� ����
		System.out.println("---- main() ���� ---");
		Scanner scan = new Scanner(System.in);
		System.out.print("����� �̸�(����) �Է� : ");
		String name = scan.nextLine();
		
		Socket socket = null;
		try {
			socket = new Socket("localhost", 10000);
			
			//�޽��� ������ ������ ���� ����(������� ����)
			ClientSender sender = new ClientSender(socket, name);
			sender.start();
			
			//�޽��� �ޱ� ������ ���� ����(������� ����)
			ClientReceiver receiver = new ClientReceiver(socket);
			receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("---- main() �� ---");
	}

	//�޽��� ������ ������
	static class ClientSender extends Thread {
		Socket socket;
		String name;
		DataOutputStream out;
		
		ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
			
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				System.out.println("[���ܹ߻�] ClientSender ������ "
						+ "out ��ü ���� ����");
			}
		}
		@Override
		public void run() {
			//�޽��� �ۼ��ϰ�, �ۼ��� �޽��� ������ ����(��� �ݺ�)
			Scanner sc = new Scanner(System.in);
			if (out == null) {
				System.out.println("[���ܹ߻�] ��¿밴ü�� ��� �����մϴ�");
				return;
			}
			try {
				out.writeUTF(name); //ù��° �޽��� ���� : �̸�(����/���̵�)
				
				while (true) {
					System.out.print("�޽��� �ۼ�> ");
					String msg = sc.nextLine();
					if ("exit".equalsIgnoreCase(msg)) {
						break;
					}
					
					//������ �޽��� ���� : [ȫ�浿] �ȳ��ϼ���
					out.writeUTF("[" + name + "] " + msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	//�޽��� �ޱ� ������
	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		
		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			// �޽����� �޾Ƽ� ȭ�� ���(�ݺ�)
			while (true) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}







