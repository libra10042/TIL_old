package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TCPServerMultiChat {
	//key : �����ں�Ī, value: ������ �޽��� ���޿� ��ü
	HashMap<String, DataOutputStream> clients; //������ ����

	public static void main(String[] args) {
		new TCPServerMultiChat().serverStart();;
	}

	TCPServerMultiChat() {
		clients = new HashMap<>();
	}
	
	//�������� �����ϰ� ����ϴٰ� Ŭ���̾�Ʈ�� �����ϸ�
	//�޽����� �ޱ����� ������ ����(�޽��� �а� ��ü���� ����)
	private void serverStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println(">> ������ ���۵Ǿ����ϴ�....");
			System.out.println("����IP�ּ�:��Ʈ - "
					+ InetAddress.getLocalHost().getHostAddress()
					+ ":" + serverSocket.getLocalPort());
			//���Ӵ��, ���ӵǸ� �б����� ������ ���� - �ݺ�
			while (true) {
				socket = serverSocket.accept();
				System.out.println("["+ socket.getInetAddress()
						+ ":" + socket.getPort() + "] ����");
				
				//���ӵ� Ŭ���̾�Ʈ�� ���� ó�� - ������ ����
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start(); //������� ���� ��Ű��
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ServerReceiver : ���޹��� Socket�� �̿��ؼ� �޽����ް�, ��ü���� ����
	// ������ �� : �ʵ� clients �� �߰�
	// ����� �� : �ʵ� clients ���� ���� ó��
	private class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in; //�޽����� ���� �� ���
		DataOutputStream out; //�ʵ� clients ��Ͻ� ���
		String ip;
		String name;
		
		//������
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
				
				ip = socket.getInetAddress().getHostAddress();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			//��ó�� �޽����� �޾��� �� : ��Ī�� ��¿밴ü�� clients�� �߰�
			//�޽����� �ް�, ���ӵ� ��� ������� �޽��� ����
			
			try {
				//Ŭ���̾�Ʈ�� ���� ù��° �޽��� �б� : �̸�(����/���̵�)
				name = in.readUTF();
				System.out.println(">>������ : " + name);
				
				//��ü���� ������ ��� �˸�
				sendToAll("#"+ name + "���� �����߽��ϴ�");
				
				//������ ������ ���(clients)�� ���
				clients.put(name, out); //��Ī, ��¿밴ü
				
				//�޽����� �а�, ��ü���� �˸�(�ݺ�)
				while (true) {
					String msg = in.readUTF();
					System.out.println(name + ">> " + msg); //����ȭ�鿡 ���
					
					sendToAll(msg);
				}
				
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				//Ŭ���̾�Ʈ ���� ����� ó��
				//������ �� clients���� ���� ó��
				clients.remove(name);
				String outMsg ="<"+ name + ">���� �������ϴ�.";
				sendToAll(outMsg);
				System.out.println(outMsg); //����ȭ�鿡 ���
			}
		}
		
		//���ӵ� ��ü �ο����� ���޵� �޽��� ������
		private void sendToAll(String msg) {
			Iterator<String> ite = clients.keySet().iterator();
			while (ite.hasNext()) {
				String key = ite.next();
				DataOutputStream out = clients.get(key);
				try {
					out.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		private void sendToAll2(String msg) {
			Collection<DataOutputStream> outs = clients.values();
			for (DataOutputStream out : outs) {
				try {
					out.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}






















