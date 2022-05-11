package com.mystudy.thread01;

class ThreadParent {
	void print() {
		System.out.println("나는 ThreadTest 클래스의 super 클래스");
	}
}

//쓰레드(Thread)로 동작하는 클래스 만들기
// Thread 클래스를 상속확장(extends)해서 만들기
class ThreadTest extends Thread {
	int num = 10;
	ThreadTest() {}
	ThreadTest(int num) {
		this.num = num;
	}
	/* Thread 클래스의 run() 메소드를 오버라이딩해서
	 * 쓰레드로 처리하려는 작업을 구현
	 * 단, 쓰레드로 동작시키기 위해서는 run()이 아닌 start() 호출
	 */
	@Override
	public void run() {
		System.out.println(this.getName() + ">> run() 시작");
		for (int i = 1; i <= num; i++) {
			System.out.println(this.getName() + " : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + ">> run() 끝");
	}
}

public class ThreadExtendsExam {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		System.out.println(Thread.currentThread());
		
		ThreadTest th1 = new ThreadTest();
		//th1.run(); //단순 메소드 호출
		th1.start(); //쓰레드로 동작시키려면 start() 메소드 사용
		
		//쓰레드를 하나 더 생성해서 실행
		ThreadTest th2 = new ThreadTest(20);
		th2.start(); //쓰레드로 동작시키려면 start() 메소드 사용

		System.out.println("--- main() 끝 ---");
	}

}













