package com.mystudy.socket01_byte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientByte {

	public static void main(String[] args) {
		//클라이언트 : Socket 이용해서 서버에 접속(서버IP주소, 서버포트번호)
		Socket socket = null;
		
		try {
			System.out.println("--- 클라이언트 ----");
			// localhost : 현재컴퓨터, 127시작하는 IP
			//socket = new Socket("localhost", 10000);
			socket = new Socket("127.0.0.1", 10000);
			System.out.println(">> 서버 연결 성공~~~");
			
			//생성된 소켓에서 Input, Output 스트림 객체 생성 
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//OutputStream 이용해서 서버쪽으로 쓰기(출력, 보내기, 전송...)
//			os.write('A'); //서버쪽으로 문자 'A' 보내기
			
			byte[] buf = "안녕하세요~ 반갑습니다.".getBytes();
			os.write(buf);
			
			os.close();
			is.close();
			System.out.println(">>>> 클라이언트 종료");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}










