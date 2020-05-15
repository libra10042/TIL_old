package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEcho {
	public static void main(String[] args) {
		/* (실습) 서버측 구현 내용
		1. 서버소켓 사용해서 클라이언트 접속 대기
		2. 클라이언트 접속하면 in, out 객체 생성
		3. 클라이언트로 부터 메시지 받고(읽기, Input)
			> 받은메시지 화면출력
		4. 받은 메시지를 클라이언트에게 다시 전송(쓰기, Output)
			> 보낸메시지 화면 출력
		*/
		ServerSocket server = null;
		
		//데이터를 읽기 위한 객체를 저장할 변수 선언
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		//데이터를 쓰기 위한 객체를 저장할 변수 선언
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			System.out.println(">>> 서버 시작~");
			server = new ServerSocket(10000);
			
			//1. 서버소켓 사용해서 클라이언트 접속 대기
			System.out.println(">>> 클라이언트 접속 대기중");
			Socket socket =	server.accept();
			
			//2. 클라이언트 접속하면 in, out 객체 생성
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			//3. 클라이언트로 부터 메시지 받고(읽기, Input)
			//	> 받은메시지 화면출력
			System.out.println(">> 메시지 읽기~");
			String msg = br.readLine();
			System.out.println("받은메시지 : " + msg);
			
			//4. 받은 메시지를 클라이언트에게 다시 전송(쓰기, Output)
			//	> 보낸메시지 화면 출력
			System.out.println(">> 메시지 쓰기~");
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			
			pw.println("[서버에서 보냄] " + msg);
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>> 서버 종료");
	}

}

















