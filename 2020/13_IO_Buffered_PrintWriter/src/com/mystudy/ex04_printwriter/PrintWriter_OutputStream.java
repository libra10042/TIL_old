package com.mystudy.ex04_printwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriter_OutputStream {

	public static void main(String[] args) {
		// PrintWriter : byte�迭, ���ڰ迭 ��� ��� ����
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			fos = new FileOutputStream("file/pw_out2.txt");
			pw = new PrintWriter(fos);
			
			pw.write("�ȳ��ϼ���~~");
			pw.write("�ݰ����ϴ�.\n");
			
			pw.print("���� �ڹٰ����� ~");
			pw.print("������ �Դϴ�. �ָ����� 2�� ���ҳ׿�~~\n");
			
			pw.println("IO ������ ~~~ �����սô�.");
			pw.println("PrintWriter ���ϳ�~~");
			pw.println("----------------------");
			
			pw.printf("%10s %10s %20s\n", "����", "�ڹٱ���", "��ĥ �� ���ҳ׿�");
			pw.printf("%-50s", "����־����� �𸣰ڳ׿�. ������ �� �ϰ� �ֽ��ϴ�.");
			
			pw.flush();
			
		} catch (FileNotFoundException e) {
			System.err.println("[���ܹ߻�] ������ �����ϴ�");
		} finally {
			if (pw != null) pw.close();
		}

	}

}























