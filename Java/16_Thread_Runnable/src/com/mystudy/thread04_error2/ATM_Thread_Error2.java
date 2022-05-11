package com.mystudy.thread04_error2;

class Bank {
	int money = 0;
}

class ATM extends Thread {
	Bank bank;
	String name;
	ATM(Bank bank, String name) {
		super(name); //쓰레드명 전달
		this.bank = bank;
		this.name = name;
	}
	
	// synchronized 적용 : 메소드가 실행되는 동안 동기화 처리
	// 하나의 쓰레드가 메소드를 사용하는 동안 실행을 보장
	// 다른 쓰레드에서 사용하려고 할 때 대기상태가 됨(필드값에 대한 동기화)
	synchronized void add(int money) {//입금
		bank.money += money;
		System.out.println(Thread.currentThread()
				+ "입금: " + money + ", 통장잔액: " + bank.money);
	}
	
	synchronized void out(int money) {//출금
		bank.money -= money;
		System.out.println(Thread.currentThread()
				+ "출금: " + money + ", 통장잔액: " + bank.money);
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

public class ATM_Thread_Error2 {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		Bank bank = new Bank();
		System.out.println("은행잔고 : " + bank.money);
		
		ATM atm1 = new ATM(bank, "ATM-1");
		atm1.start();
		
		ATM atm2 = new ATM(bank, "ATM-2");
		atm2.start();
		
		System.out.println("--- main() 끝 ---");
	}

}













