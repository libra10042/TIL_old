package javaThreadMethod.exam;

public class ThreadB extends Thread{
	// �ش� �����尡 ����Ǹ� �ڱ� �ڽ��� ����͸� ���� ȹ��.
	// 5�� �ݺ��ϸ鼭 0.5�ʾ� ���鼭 total�� ���� ����.
	// ���Ŀ� notify() �޼ҵ带 ȣ���Ͽ� wait �ϰ� �ִ� �����带 �ƿ�. 
	int total; 
	
	public void run() {
		synchronized (this) {
			for(int i=0; i<5; i++) {
				System.out.println(i + "�� ���մϴ�.");
				total += i;
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			notify();
		}
	}
	
}
