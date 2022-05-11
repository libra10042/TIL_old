package com.mystudy.thread01;

class ThreadParent {
	void print() {
		System.out.println("���� ThreadTest Ŭ������ super Ŭ����");
	}
}

//������(Thread)�� �����ϴ� Ŭ���� �����
// Thread Ŭ������ ���Ȯ��(extends)�ؼ� �����
class ThreadTest extends Thread {
	int num = 10;
	ThreadTest() {}
	ThreadTest(int num) {
		this.num = num;
	}
	/* Thread Ŭ������ run() �޼ҵ带 �������̵��ؼ�
	 * ������� ó���Ϸ��� �۾��� ����
	 * ��, ������� ���۽�Ű�� ���ؼ��� run()�� �ƴ� start() ȣ��
	 */
	@Override
	public void run() {
		System.out.println(this.getName() + ">> run() ����");
		for (int i = 1; i <= num; i++) {
			System.out.println(this.getName() + " : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + ">> run() ��");
	}
}

public class ThreadExtendsExam {

	public static void main(String[] args) {
		System.out.println("--- main() ���� ---");
		System.out.println(Thread.currentThread());
		
		ThreadTest th1 = new ThreadTest();
		//th1.run(); //�ܼ� �޼ҵ� ȣ��
		th1.start(); //������� ���۽�Ű���� start() �޼ҵ� ���
		
		//�����带 �ϳ� �� �����ؼ� ����
		ThreadTest th2 = new ThreadTest(20);
		th2.start(); //������� ���۽�Ű���� start() �޼ҵ� ���

		System.out.println("--- main() �� ---");
	}

}













