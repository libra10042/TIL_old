package javaThreadMethod.exam;

public class JoinExam {
	public static void main(String[] args) {
		MyThread5 thread = new MyThread5();
		thread.start();
		
		
		
		System.out.println("����");
		
		try {
			thread.join();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("����");
	}
}
