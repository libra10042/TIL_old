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
		// �⺻ ������ Ÿ������ �а�, ����
		File file = new File("file/data_io_stream.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			//���Ͽ� ����, ����� ������ �о����
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			//�⺻ ������ Ÿ������ ������ ����
			dos.writeInt(10000);
			dos.writeBoolean(true);
			dos.writeByte(127);
			dos.writeDouble(Math.PI);
			dos.writeUTF("abc�ѱ۹��ڿ�");
			dos.writeUTF("Hello Java");
			
			//==========================
			//����� ������ �о����(ȭ�����)
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			
			//(����) ���� �о�ö��� ������ ���� + Ÿ���� ��ġ�ؼ� ���� ��
			int readValue = dis.readInt();
			System.out.println("ù��° : " + readValue);
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			System.out.println(dis.readUTF());
		
		} catch (FileNotFoundException e) {
			System.err.println("[err-���ܹ߻�] ��� �� ���� ���� ����");
			System.out.println("[out-���ܹ߻�] ��� �� ���� ���� ����");
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













