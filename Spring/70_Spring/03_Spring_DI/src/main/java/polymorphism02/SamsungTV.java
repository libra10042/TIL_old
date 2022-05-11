package polymorphism02;

class SamsungTV implements TV {
	private SonySpeacker speaker;
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}
	public SamsungTV(SonySpeacker speaker) {
		System.out.println(">> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}
	public SamsungTV(SonySpeacker speaker, int price) {
		System.out.println(">> SamsungTV(speaker,price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(SonySpeacker speaker, int width, int height) {
		System.out.println(">> SamsungTV(speaker,width,height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV - 전원ON");
	}
	public void powerOff() {
		System.out.println("SamsungTV - 전원OFF");
	}
	public void volumeUp() {
		System.out.println("SamsungTV - 소리크게");
		speaker.volumnUp();
	}
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게");
		speaker.volumnDown();
	}

	//-----------------------------------------
	public void initMethod() {
		System.out.println("SamsungTV - initMethod() 실행");
	}
	public void destroyMethod() {
		System.out.println("SamsungTV - destroyMethod() 실행");
	}
	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}
	
	
}








