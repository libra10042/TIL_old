package com.mystudy.ex04_printwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_Writer {

	public static void main(String[] args) {
		//File -> FileWriter -> (BufferedWriter) -> PrintWriter
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(new File("file/pw_out.txt"));
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			//pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("file/pw_out.txt"))));
			
			pw.write("�ȳ��ϼ���~~");
			pw.write("�ݰ����ϴ�.\n");
			
			pw.print("���� �ڹٰ����� ~");
			pw.print("������ �Դϴ�. �ָ����� 2�� ���ҳ׿�~~\n");
			
			pw.println("�����Դϴ�~~~ �����սô�.");
			pw.println("----------------------");
			
			pw.printf("%10s %10s %20s\n", "����", "�ڹٱ���", "��ĥ �� ���ҳ׿�");
			pw.printf("%-50s", "����־����� �𸣰ڳ׿�. ������ �� �ϰ� �ֽ��ϴ�.");
			
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
		}
	}

}












