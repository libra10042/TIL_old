package javaDemon.exam;

public class DamonThread implements Runnable{
	
	@Override
	public void run() {
		while(true) {
			System.out.println("데몬 스레드가 실행중입니다.");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new DamonThread());
		thread.setDaemon(true);
		thread.start();
		
		try {
			Thread.sleep(1000);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("메인 스레드가 종료됩니다.");
	}

}
