package com.mystudy.thread02;

class ThreadParent {
	void print() {
		System.out.println("나는 ThreadImp 클래스의 super 클래스");
	}
}

//쓰레드로 동작하도록 만들기 위해 Runnable 인터페이스를 구현
class ThreadImp extends ThreadParent implements Runnable {

	@Override
	public void run() {
		super.print();
		System.out.println("ThreadImp.run() : Runable 인터페이스 구현");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadImpRunnable {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		
		// Runnable 인터페이스를 구현한 객체를 쓰레드로 사용하려면
		// Thread 클래스의 생성자에 Runnable 구현체를 전달해서 생성 사용
		ThreadImp thImp = new ThreadImp();
		
		//Thread 객체 생성시 ThreadImp 객체를 주입
		Thread th = new Thread(thImp);
		th.start();
		
		System.out.println("--- main() 끝 ---");
	}

}
















