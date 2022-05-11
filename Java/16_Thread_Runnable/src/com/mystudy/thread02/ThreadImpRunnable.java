package com.mystudy.thread02;

class ThreadParent {
	void print() {
		System.out.println("���� ThreadImp Ŭ������ super Ŭ����");
	}
}

//������� �����ϵ��� ����� ���� Runnable �������̽��� ����
class ThreadImp extends ThreadParent implements Runnable {

	@Override
	public void run() {
		super.print();
		System.out.println("ThreadImp.run() : Runable �������̽� ����");
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
		System.out.println("--- main() ���� ---");
		
		// Runnable �������̽��� ������ ��ü�� ������� ����Ϸ���
		// Thread Ŭ������ �����ڿ� Runnable ����ü�� �����ؼ� ���� ���
		ThreadImp thImp = new ThreadImp();
		
		//Thread ��ü ������ ThreadImp ��ü�� ����
		Thread th = new Thread(thImp);
		th.start();
		
		System.out.println("--- main() �� ---");
	}

}
















