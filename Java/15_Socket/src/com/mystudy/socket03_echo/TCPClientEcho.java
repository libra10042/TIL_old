package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClientEcho {
	public static void main(String[] args) {
		/* (실습) 클라이언트 구현
		1. 소켓사용해서 서버에 접속
		2. 소켓에서 in, out 객체 추출 후 IO작업용 객체 생성 
		3. 서버쪽으로 메시지 전송(쓰기, Output)
		4. 서버쪽에서 보내온 메시지 수신(읽기, Input)
			> 받은 메시지 화면 출력
		*/
		Socket socket = null;
		
		//데이터를 읽기 위한 객체를 저장할 변수 선언
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		//데이터를 쓰기 위한 객체를 저장할 변수 선언
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			System.out.println("------ 클라이언트 ---------");
			//1. 소켓사용해서 서버에 접속
			socket = new Socket("localhost", 10000);
			System.out.println(">>> 서버 접속 완료");
			
			//2. 소켓에서 in, out 객체 추출 후 IO작업용 객체 생성 
			//3. 서버쪽으로 메시지 전송(쓰기, Output)
			System.out.println(">> 메시지 쓰기(client -> server)");
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			
			String msg = "안녕하세요~ 반갑습니다";
			pw.println(msg);
			pw.flush(); //버퍼데이터 강제 출력 처리
			System.out.println("> 보낸메시지 : " + msg);
			System.out.println(">> 메시지 보내기 완료");
			
			//4. 서버쪽에서 보내온 메시지 수신(읽기, Input)
			//	> 받은 메시지 화면 출력
			System.out.println(">> 메시지 읽기(client <- server)");
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String receiveMsg = br.readLine();
			System.out.println(">> 받은메시지 : " + receiveMsg);
			
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
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>> 클라이언트 종료");
	}

}












