package javaThread.exam;

public class MyThread2 implements Runnable{
	String str;
	public MyThread2(String str) {
		this.str = str; 
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(str);
			
			try {
				Thread.sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
