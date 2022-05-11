package com.mystudy.ex01_type_casting;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("=== Car 클래스 ===");
		Car car = new Car();
		car.type = "자동차";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("=== FireEngine 클래스 ===");
		FireEngine fe = new FireEngine();
		fe.type = "소방차";
		System.out.println("타입 : " + fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("====== Car ======");
		Car carTemp = new Car();
		carTemp.drive();
		carTemp.stop();
		//carTemp.siren(); //컴파일오류 undefined : Car 타입에는 siren() 없음
		
		System.out.println("==== Car <- FireEngine 변경후 ===");
		carTemp = fe; //Car <- FireEngine : 자동형변환(큰타입 <- 작은타입)
		carTemp.drive();
		carTemp.stop();
		//carTemp.siren(); //컴파일오류 undefined : Car 타입에는 siren() 없음
		
		System.out.println("==== FireEngine <- Car 변경후");
		/*
		//FireEngine <- Car
		//명시적형변환, 강제형변환
		//[실행오류]실행시 ClassCastException 오류 발생
		fe = (FireEngine) car; //원래 Car 타입을 FireEngine 바꾸어 실행하면 오류발생
		*/
		
		//FireEngine <- Car타입에 저장된 FireEngine
		fe = (FireEngine) carTemp; //FireEngine <- Car타입에 저장된 FireEngine
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		//소방차 타입으로 변경 후 사이렌 울리기
		((FireEngine) carTemp).siren(); //내부저장객체 : FireEngine 이라 가능
		
		//실행시 오류 ClassCastException 발생
		((FireEngine) car).siren(); //문법적오류는 없으나 원래 Car는 siren() 없음
	}

}










