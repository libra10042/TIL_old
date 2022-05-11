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
			
			pw.write("안녕하세요~~");
			pw.write("반갑습니다.\n");
			
			pw.print("지금 자바공부중 ~");
			pw.print("수요일 입니다. 주말까지 2일 남았네요~~\n");
			
			pw.println("오전입니다~~~ 집중합시다.");
			pw.println("----------------------");
			
			pw.printf("%10s %10s %20s\n", "이제", "자바기초", "며칠 안 남았네요");
			pw.printf("%-50s", "재미있었는지 모르겠네요. 하지만 잘 하고 있습니다.");
			
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
		}
	}

}












