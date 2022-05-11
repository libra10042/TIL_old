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
	//key : 접속자별칭, value: 접속자 메시지 전달용 객체
	HashMap<String, DataOutputStream> clients; //접속자 명단

	public static void main(String[] args) {
		new TCPServerMultiChat().serverStart();;
	}

	TCPServerMultiChat() {
		clients = new HashMap<>();
	}
	
	//서버소켓 생성하고 대기하다가 클라이언트가 접속하면
	//메시지를 받기위한 쓰레드 생성(메시지 읽고 전체에게 전달)
	private void serverStart() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println(">> 서버가 시작되었습니다....");
			System.out.println("서버IP주소:포트 - "
					+ InetAddress.getLocalHost().getHostAddress()
					+ ":" + serverSocket.getLocalPort());
			//접속대기, 접속되면 읽기전용 쓰레드 생성 - 반복
			while (true) {
				socket = serverSocket.accept();
				System.out.println("["+ socket.getInetAddress()
						+ ":" + socket.getPort() + "] 접속");
				
				//접속된 클라이언트에 대한 처리 - 쓰레드 생성
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start(); //쓰레드로 동작 시키기
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ServerReceiver : 전달받은 Socket을 이용해서 메시지받고, 전체에게 전달
	// 생성될 때 : 필드 clients 에 추가
	// 종료될 때 : 필드 clients 에서 삭제 처리
	private class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in; //메시지를 읽을 때 사용
		DataOutputStream out; //필드 clients 등록시 사용
		String ip;
		String name;
		
		//생성자
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
			//맨처음 메시지를 받았을 때 : 별칭과 출력용객체를 clients에 추가
			//메시지를 받고, 접속된 모든 사람에게 메시지 전달
			
			try {
				//클라이언트로 부터 첫번째 메시지 읽기 : 이름(별명/아이디)
				name = in.readUTF();
				System.out.println(">>접속자 : " + name);
				
				//전체에게 접속한 사람 알림
				sendToAll("#"+ name + "님이 입장했습니다");
				
				//접속자 정보를 목록(clients)에 등록
				clients.put(name, out); //별칭, 출력용객체
				
				//메시지를 읽고, 전체에게 알림(반복)
				while (true) {
					String msg = in.readUTF();
					System.out.println(name + ">> " + msg); //서버화면에 출력
					
					sendToAll(msg);
				}
				
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				//클라이언트 접속 종료시 처리
				//종료할 때 clients에서 삭제 처리
				clients.remove(name);
				String outMsg ="<"+ name + ">님이 나갔습니다.";
				sendToAll(outMsg);
				System.out.println(outMsg); //서버화면에 출력
			}
		}
		
		//접속된 전체 인원에게 전달된 메시지 보내기
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























