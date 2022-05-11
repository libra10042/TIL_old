package com.mystudy.ex01_type_casting;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("=== Car Ŭ���� ===");
		Car car = new Car();
		car.type = "�ڵ���";
		System.out.println("Ÿ�� : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("=== FireEngine Ŭ���� ===");
		FireEngine fe = new FireEngine();
		fe.type = "�ҹ���";
		System.out.println("Ÿ�� : " + fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("====== Car ======");
		Car carTemp = new Car();
		carTemp.drive();
		carTemp.stop();
		//carTemp.siren(); //�����Ͽ��� undefined : Car Ÿ�Կ��� siren() ����
		
		System.out.println("==== Car <- FireEngine ������ ===");
		carTemp = fe; //Car <- FireEngine : �ڵ�����ȯ(ūŸ�� <- ����Ÿ��)
		carTemp.drive();
		carTemp.stop();
		//carTemp.siren(); //�����Ͽ��� undefined : Car Ÿ�Կ��� siren() ����
		
		System.out.println("==== FireEngine <- Car ������");
		/*
		//FireEngine <- Car
		//���������ȯ, ��������ȯ
		//[�������]����� ClassCastException ���� �߻�
		fe = (FireEngine) car; //���� Car Ÿ���� FireEngine �ٲپ� �����ϸ� �����߻�
		*/
		
		//FireEngine <- CarŸ�Կ� ����� FireEngine
		fe = (FireEngine) carTemp; //FireEngine <- CarŸ�Կ� ����� FireEngine
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		//�ҹ��� Ÿ������ ���� �� ���̷� �︮��
		((FireEngine) carTemp).siren(); //�������尴ü : FireEngine �̶� ����
		
		//����� ���� ClassCastException �߻�
		((FireEngine) car).siren(); //������������ ������ ���� Car�� siren() ����
	}

}










