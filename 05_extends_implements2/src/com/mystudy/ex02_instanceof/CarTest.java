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
		System.out.println("=== Car타입에 자녀타입 저장 사용 =========");
		Car carTemp = new Car();
		carTemp.drive();
		carTemp.stop();
		
		System.out.println("--- Car <- Ambulance (Super <- sub) --");
		carTemp = am;
		carTemp.drive();
		carTemp.stop();
		System.out.println("-- Am -> Car -> Am (가능)---");
		((Ambulance)carTemp).siren();
		
		System.out.println("-- Am -> Car -> Fe (안됨-오류발생 하지말것)---");
		//실행시 예외 발생 ClassCastException
		//((FireEngine)carTemp).siren(); //ClassCastException
		//((FireEngine)carTemp).water();
		
		System.out.println("--- Car 타입에 저장된 객체의 타입 확인 ---");
		carTemp = fe;
		if (carTemp instanceof Object) {
			System.out.println("Object 타입 입니다");
		}
		if (carTemp instanceof Car) {
			System.out.println("Car 타입 입니다");
		}
		if (carTemp instanceof Ambulance) {
			System.out.println("Ambulance 타입 입니다");
		}
		if (carTemp instanceof FireEngine) {
			System.out.println("FireEngine 타입 입니다");
		}
		
		System.out.println("--- 타입체크 후 동작시키기 ---");
		System.out.println(">> Car 타입 ---");
		if (carTemp instanceof Car) {
			carTemp.drive();
			carTemp.stop();
		}
		
		System.out.println(">> Ambulance 타입 --");
		if (carTemp instanceof Ambulance) {
			carTemp.drive();
			carTemp.stop();
			((Ambulance) carTemp).siren();
		}
		
		System.out.println(">> FireEngine 타입 --");
		if (carTemp instanceof FireEngine) {
			carTemp.drive();
			carTemp.stop();
			((FireEngine) carTemp).siren();
			((FireEngine) carTemp).water();
		}
		
		System.out.println("================");
		System.out.println("--- Car 타입 전달(타입체크)---");
		executeMethod(car);
		
		System.out.println("--- Ambulance 타입 전달(타입체크) ---");
		executeMethod(am);
		
		System.out.println("--- FireEngine 타입 전달(타입체크) ---");
		executeMethod(fe);
		
		System.out.println("\n======= carTemp ==========");
		carTemp = am;
		executeMethod(carTemp);
		
		
		System.out.println("---main() 끝 ---");
	}
	
/*
	//메소드 오버로딩(overloading) 
	static void executeMethod(Car car) {
		System.out.println(">> Car 타입 ---");
		car.drive();
		car.stop();
	}
	static void executeMethod(Ambulance am) {
		System.out.println(">> Ambulance 타입 ---");
		am.drive();
		am.stop();
		am.siren();
	}
	static void executeMethod(FireEngine fe) {
		System.out.println(">> FireEngine 타입 ---");
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
	}
*/	
	//타입 체크 instanceof 사용해서 메소드 실행
	static void executeMethod(Car car) {
		System.out.println("::: Car 타입 입니다----");
		car.drive();
		car.stop();
		
		//타입확인 : instanceof
		if (car instanceof Ambulance) {
			System.out.println(":: Ambulance 타입 ---");
			((Ambulance) car).siren();
		}
		if (car instanceof FireEngine) {
			System.out.println(":: FireEngine 타입 ---");
			((FireEngine) car).siren();
			((FireEngine) car).water();
		}
	}
	

}









