package polymorphism03;

class SamsungTV implements TV {
	public void powerOn() {
		System.out.println("SamsungTV - 전원ON");
	}
	public void powerOff() {
		System.out.println("SamsungTV - 전원OFF");
	}
	public void volumeUp() {
		System.out.println("SamsungTV - 소리크게");
	}
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게");
	}

}








