package javaIO.exam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CharExam02 {
	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null; 
		try {	
			
			br =new BufferedReader(new FileReader("src/javaIO/exam/CharExam02.java"));
			pw = new PrintWriter(new FileWriter("test.txt"));
			String line = null; 
			
			while((line = br.readLine())!= null) {
				pw.println(line);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pw.close();
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
