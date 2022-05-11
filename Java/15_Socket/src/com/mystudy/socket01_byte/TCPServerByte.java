package com.mystudy.socket01_byte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerByte {

	public static void main(String[] args) {
		// 서버측 : ServerSocket 객체가 클라이언트 접속을 처리
		ServerSocket server = null;
		
		try {
			System.out.println("[서버] ServerSocket 객체생성");
			//서버쪽에서 10000번 포트를 열고 서비스 하려고 대기
			server = new ServerSocket(10000);
			
			//서버에서 해당포트로 접속한 클라이언트와 연결된 소켓 생성
			System.out.println("[서버] 클라이언트 접속을 기다리는 중~~");
			Socket socket = server.accept();
			
			System.out.println("[서버] 1개의 클라이언트 접속");
			
			//소켓에서 Input, Output 스트림 객체 생성
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//클라이언트에서 보내온 메시지 읽기(InputStream)
//			int readValue = is.read(); //1 byte 읽기
//			System.out.println("[서버] 클라이언트로 부터 받은 메시지 : " 
//					+ (char)readValue);
			
			byte[] buf = new byte[100];
			is.read(buf);
			System.out.println("[서버] 받은메시지 : " + new String(buf));
			
			System.out.println(">>> 서버종료");
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}






