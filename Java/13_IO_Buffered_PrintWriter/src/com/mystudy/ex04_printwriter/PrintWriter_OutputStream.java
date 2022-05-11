package com.mystudy.ex04_printwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class PrintWriter_OutputStream {

	public static void main(String[] args) {
		// PrintWriter : byte계열, 문자계열 모두 사용 가능
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			fos = new FileOutputStream("file/pw_out2.txt");
			pw = new PrintWriter(fos);
			
			pw.write("안녕하세요~~");
			pw.write("반갑습니다.\n");
			
			pw.print("지금 자바공부중 ~");
			pw.print("수요일 입니다. 주말까지 2일 남았네요~~\n");
			
			pw.println("IO 공부중 ~~~ 집중합시다.");
			pw.println("PrintWriter 편하네~~");
			pw.println("----------------------");
			
			pw.printf("%10s %10s %20s\n", "이제", "자바기초", "며칠 안 남았네요");
			pw.printf("%-50s", "재미있었는지 모르겠네요. 하지만 잘 하고 있습니다.");
			
			pw.flush();
			
		} catch (FileNotFoundException e) {
			System.err.println("[예외발생] 파일이 없습니다");
		} finally {
			if (pw != null) pw.close();
		}

	}

}























