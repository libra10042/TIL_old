package com.mystudy.socket04_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/* (실습) 서버측 구현 내용
1. 서버소켓 사용해서 클라이언트 접속 대기
2. 클라이언트 접속하면 in, out 객체 생성
<반복처리>
	3. 클라이언트로 부터 메시지 받고(읽기, Input)
		> 받은메시지 화면출력
	4. 받은 메시지를 클라이언트에게 다시 전송(쓰기, Output)
		> 보낸메시지 화면 출력
------
클라이언트에서 null을 받거나 "exit" 메시지 받으면 반복 종료 처리
*/
public class TCPServerEchoWhile {

	public static void main(String[] args) {
		ServerSocket server = null;
		
		//데이터를 읽기 위한 객체를 저장할 변수 선언
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		//데이터를 쓰기 위한 객체를 저장할 변수 선언
		OutputStream os = null;
		PrintWriter pw = null;
		
		System.out.println(">>> 서버 시작~~~");
		
		try {
			server = new ServerSocket(10000);
			System.out.println(">> 클라이언트 접속 대기중~~~");
			Socket socket = server.accept();
			
			//연결된 소켓과 데이터를 주고받기 위한 I/O 객체 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			//바이트(byte) 처리 계열을 문자(char) 처리 계열로 변환
			isr = new InputStreamReader(is);
			
			//버퍼(buffer) 사용으로 편리하게 라인단위 입력, 출력 객체 생성
			br = new BufferedReader(isr);
			pw = new PrintWriter(os);
			
			//================================
			//클라이언트에서 보내 데이터 읽고, 클라이언트 쪽으로 쓰기 반복
			while (true) {
				System.out.println(">> 데이터 읽기");
				String msg = br.readLine();
				System.out.println("받은메시지 : " + msg);
				
				//클라이언트로 부터 받은 메시지가 없거나(null)
				// exit이면 종료 처리
				if (msg == null || "exit".equalsIgnoreCase(msg)) {
					System.out.println(">> 종료합니다");
					break;
				}
				System.out.println(">> 데이터 보내기");
				pw.println(msg); //쓰기
				pw.flush(); // 버퍼 데이터 보내기
				System.out.println("보낸메시지 : " + msg);
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













