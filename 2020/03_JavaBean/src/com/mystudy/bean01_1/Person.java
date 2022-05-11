package com.mystudy.bean01_1;

// Java Bean : ������ �����ϱ� ���� Ŭ����
public class Person {
	private String name; //����
	int age; //����
	
	//setter �޼ҵ� : �����͸� ������ �� ���
	public void setName(String name) {
		this.name = name; //this : ���簴ü(���� ���Ǵ� ��ü-�ν��Ͻ�)
	}
	public void setAge(int age) {
		if (age < 0 || age > 150) {
			System.out.println("[���ܹ߻�] ���̹���[0~150]�� ���" );
			return;
		}
		this.age = age;
	}
	
	//getter �żҵ� : �����͸� ��ȸ�ؼ� ������ �� ���
	public String getName() {
		return this.name; //return name; ���� 
	}
	public int getAge() {
		return this.age; //return age; ���� 
	}
	
	public void showData() {
		System.out.println("name: " + name + ", age: " + age);
	}
	
}






