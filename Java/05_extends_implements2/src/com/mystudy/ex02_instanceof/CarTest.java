package com.mystudy.ex02_instanceof;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("=== Car ===");
		Car car = new Car();
		car.drive();
		car.stop();

		System.out.println("=== Ambulance ===");
		Ambulance am = new Ambulance();
		am.drive();
		am.stop();
		am.siren();
		
		System.out.println("=== FireEngine ===");
		FireEngine fe = new FireEngine();
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("-------------");
		System.out.println("=== CarŸ�Կ� �ڳ�Ÿ�� ���� ��� =========");
		Car carTemp = new Car();
		carTemp.drive();
		carTemp.stop();
		
		System.out.println("--- Car <- Ambulance (Super <- sub) --");
		carTemp = am;
		carTemp.drive();
		carTemp.stop();
		System.out.println("-- Am -> Car -> Am (����)---");
		((Ambulance)carTemp).siren();
		
		System.out.println("-- Am -> Car -> Fe (�ȵ�-�����߻� ��������)---");
		//����� ���� �߻� ClassCastException
		//((FireEngine)carTemp).siren(); //ClassCastException
		//((FireEngine)carTemp).water();
		
		System.out.println("--- Car Ÿ�Կ� ����� ��ü�� Ÿ�� Ȯ�� ---");
		carTemp = fe;
		if (carTemp instanceof Object) {
			System.out.println("Object Ÿ�� �Դϴ�");
		}
		if (carTemp instanceof Car) {
			System.out.println("Car Ÿ�� �Դϴ�");
		}
		if (carTemp instanceof Ambulance) {
			System.out.println("Ambulance Ÿ�� �Դϴ�");
		}
		if (carTemp instanceof FireEngine) {
			System.out.println("FireEngine Ÿ�� �Դϴ�");
		}
		
		System.out.println("--- Ÿ��üũ �� ���۽�Ű�� ---");
		System.out.println(">> Car Ÿ�� ---");
		if (carTemp instanceof Car) {
			carTemp.drive();
			carTemp.stop();
		}
		
		System.out.println(">> Ambulance Ÿ�� --");
		if (carTemp instanceof Ambulance) {
			carTemp.drive();
			carTemp.stop();
			((Ambulance) carTemp).siren();
		}
		
		System.out.println(">> FireEngine Ÿ�� --");
		if (carTemp instanceof FireEngine) {
			carTemp.drive();
			carTemp.stop();
			((FireEngine) carTemp).siren();
			((FireEngine) carTemp).water();
		}
		
		System.out.println("================");
		System.out.println("--- Car Ÿ�� ����(Ÿ��üũ)---");
		executeMethod(car);
		
		System.out.println("--- Ambulance Ÿ�� ����(Ÿ��üũ) ---");
		executeMethod(am);
		
		System.out.println("--- FireEngine Ÿ�� ����(Ÿ��üũ) ---");
		executeMethod(fe);
		
		System.out.println("\n======= carTemp ==========");
		carTemp = am;
		executeMethod(carTemp);
		
		
		System.out.println("---main() �� ---");
	}
	
/*
	//�޼ҵ� �����ε�(overloading) 
	static void executeMethod(Car car) {
		System.out.println(">> Car Ÿ�� ---");
		car.drive();
		car.stop();
	}
	static void executeMethod(Ambulance am) {
		System.out.println(">> Ambulance Ÿ�� ---");
		am.drive();
		am.stop();
		am.siren();
	}
	static void executeMethod(FireEngine fe) {
		System.out.println(">> FireEngine Ÿ�� ---");
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
	}
*/	
	//Ÿ�� üũ instanceof ����ؼ� �޼ҵ� ����
	static void executeMethod(Car car) {
		System.out.println("::: Car Ÿ�� �Դϴ�----");
		car.drive();
		car.stop();
		
		//Ÿ��Ȯ�� : instanceof
		if (car instanceof Ambulance) {
			System.out.println(":: Ambulance Ÿ�� ---");
			((Ambulance) car).siren();
		}
		if (car instanceof FireEngine) {
			System.out.println(":: FireEngine Ÿ�� ---");
			((FireEngine) car).siren();
			((FireEngine) car).water();
		}
	}
	

}









