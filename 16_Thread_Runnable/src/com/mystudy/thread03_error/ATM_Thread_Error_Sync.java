package com.mystudy.thread03_error;

class ATM_Error_Sync implements Runnable {
	int money;
	ATM_Error_Sync() {}
	ATM_Error_Sync(int money) {
		this.money = money;
	}
	
	// synchronized 적용 : 메소드가 실행되는 동안 동기화 처리
	// 하나의 쓰레드가 메소드를 사용하는 동안 실행을 보장
	// 다른 쓰레드에서 사용하려고 할 때 대기상태가 됨(필드값에 대한 동기화)
	synchronized void add(int money) {//입금
		this.money += money;
		System.out.println(Thread.currentThread()
				+ "입금: " + money + ", 통장잔액: " + this.money);
	}
	
	synchronized void out(int money) {//출금
		this.money -= money;
		System.out.println(Thread.currentThread()
				+ "출금: " + money + ", 통장잔액: " + this.money);
	}
	void bankSleep(int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		add(1000);
		bankSleep(1000);
		out(500);
		bankSleep(1000);
		out(300);
		bankSleep(1000);
		out(200);
	}
}

public class ATM_Thread_Error_Sync {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		ATM_Error_Sync bank = new ATM_Error_Sync();
		System.out.println("은행잔고 : " + bank.money);
		
		Thread th1 = new Thread(bank, "ATM-1");
		Thread th2 = new Thread(bank, "ATM-2");
		Thread th3 = new Thread(bank, "ATM-3");
		th1.start();
		th2.start();
		th3.start();
		
		System.out.println("--- main() 끝 ---");
	}

}







