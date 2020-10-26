package javaThreadMethod.exam;

public class ThreadB extends Thread{
	// 해당 스레드가 실행되면 자기 자신의 모니터링 락을 획득.
	// 5번 반복하면서 0.5초씩 쉬면서 total에 값을 누적.
	// 그후에 notify() 메소드를 호출하여 wait 하고 있는 스레드를 꺠움. 
	int total; 
	
	public void run() {
		synchronized (this) {
			for(int i=0; i<5; i++) {
				System.out.println(i + "를 더합니다.");
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
