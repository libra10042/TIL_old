package com.mystudy.bean01_1;

// Java Bean : 데이터 저장하기 위한 클래스
public class Person {
	private String name; //성명
	int age; //나이
	
	//setter 메소드 : 데이터를 저장할 때 사용
	public void setName(String name) {
		this.name = name; //this : 현재객체(현재 사용되는 객체-인스턴스)
	}
	public void setAge(int age) {
		if (age < 0 || age > 150) {
			System.out.println("[예외발생] 나이범위[0~150]를 벗어남" );
			return;
		}
		this.age = age;
	}
	
	//getter 매소드 : 데이터를 조회해서 참조할 때 사용
	public String getName() {
		return this.name; //return name; 동일 
	}
	public int getAge() {
		return this.age; //return age; 동일 
	}
	
	public void showData() {
		System.out.println("name: " + name + ", age: " + age);
	}
	
}






