package com.mystudy.socket02_line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerLine {

	public static void main(String[] args) {
		// 서버 : 라인단위 입력 처리
		System.out.println(">> 서버 시작");
		ServerSocket server = null;
		
		try {
			//1. ServerSocket 객체 생성 - 대기할 포트번호(port) 지정
			server = new ServerSocket(10000);
			
			//2. 서버소켓 대기중 접속한 Socket과 연결된 Socket 객체 생성
			System.out.println(">> 접속 대기중....");
			Socket socket = server.accept();
			System.out.println(">> 클라이언트 접속");
			
			//3. Socket으로 부터 InputStream, OutputStream 객체 생성(받기,가져오기)
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			
			//InputStream -> Reader 타입 변경
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//4. 받은 메시지 있으면 읽기
			String msg = br.readLine();
			System.out.println("[서버-받은메시지] " + msg);
			
			//5. 보낼 메시지 있으면 쓰기
			//(구현안함)
			
			//6. 자원반납(close)
			br.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(">>> 서버 종료");
	}

}








