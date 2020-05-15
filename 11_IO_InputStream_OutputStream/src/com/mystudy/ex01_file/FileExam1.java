package com.mystudy.ex01_file;

import java.io.File;
import java.io.IOException;

public class FileExam1 {

	public static void main(String[] args) {
		//파일명 : temp.txt - 파일명.확장자(명)
		File file1 = new File("temp.txt");
		
		//File 객체생성은 파일의 존재여부와 관계없이 생성 가능
		System.out.println(file1);
		
		// c:\temp\aaa\a1\temp.txt : 절대경로 방식(root부터 시작)
		File file2 = new File("c:\\temp\\aaa\\a1\\temp.txt");
		file2 = new File("c:/temp/aaa/a1/temp.txt"); //경로구분자 '/' 사용
		System.out.println(file2);
		
		//상대경로 방식(. : 현재위치, .. : 상위디렉토리(폴더)) : 현재 위치로 부터 이동
		File file3 = new File("file\\temp.txt");
		file3 = new File("file/temp.txt");
		
		System.out.println("\n--- File getAbsolutePath() ----");
		System.out.println("파일위치(file1) : " + file1.getAbsolutePath());
		System.out.println("파일위치(file2) : " + file2.getAbsolutePath());
		System.out.println("파일위치(file3) : " + file3.getAbsolutePath());
		
		System.out.println("--- File exists() ----");
		System.out.println("있냐(file1) : " + file1.exists());
		System.out.println("있냐(file2) : " + file2.exists());
		System.out.println("있냐(file3) : " + file3.exists());
		
		System.out.println("--- File getName() ----");
		System.out.println("파일명(file1) : " + file1.getName());
		System.out.println("파일명(file2) : " + file2.getName());
		System.out.println("파일명(file3) : " + file3.getName());
		
		System.out.println("\n--- 파일 속성 정보 -----");
		System.out.println("file1.length() : " + file1.length());
		System.out.println("file1.canRead() : " + file1.canRead());
		System.out.println("file1.canWrite() : " + file1.canWrite());
		System.out.println("file1.canExecute() : " + file1.canExecute());
		
		System.out.println("\n--- isDirectory(), isFile() ---");
		System.out.println("file1.isDirectory() : " + file1.isDirectory());
		System.out.println("file1.isFile() : " + file1.isFile());
		
		//파일 생성 및 삭제
		File file4 = new File("file/temp4.txt");
		try {
			//파일만 생성, 폴더(디렉토리)없으면 IOException 발생
			//해당위치에 파일이 있으면 만들지 않고, 없으면 파일을 생성
			boolean isSuccess = file4.createNewFile();
			System.out.println("파일생성여부 : " + isSuccess);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		file4.delete(); //파일삭제
	
		System.out.println("\n==========================");
		System.out.println("File.separator : " + File.separator);
		System.out.println("File.separatorChar : " + File.separatorChar);
	
		System.out.println("File.pathSeparator : " + File.pathSeparator);
		
		System.out.println("------");
		File[] listRoots = File.listRoots();
		for (File root : listRoots) {
			System.out.println(root);
		}
	}
	

}











