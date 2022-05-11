package com.mystudy.ex05_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStream_Exam {

	public static void main(String[] args) {
		// DataInputStream, DataOutputStream
		// 기본 데이터 타입으로 읽고, 쓰기
		File file = new File("file/data_io_stream.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			//파일에 쓰고, 저장된 데이터 읽어오기
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			//기본 데이터 타입으로 데이터 저장
			dos.writeInt(10000);
			dos.writeBoolean(true);
			dos.writeByte(127);
			dos.writeDouble(Math.PI);
			dos.writeUTF("abc한글문자열");
			dos.writeUTF("Hello Java");
			
			//==========================
			//저장된 데이터 읽어오기(화면출력)
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			
			//(주의) 값을 읽어올때는 저장한 순서 + 타입을 일치해서 읽을 것
			int readValue = dis.readInt();
			System.out.println("첫번째 : " + readValue);
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			System.out.println(dis.readUTF());
		
		} catch (FileNotFoundException e) {
			System.err.println("[err-예외발생] 경로 및 파일 설정 오류");
			System.out.println("[out-예외발생] 경로 및 파일 설정 오류");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
				if (dis != null) dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}













