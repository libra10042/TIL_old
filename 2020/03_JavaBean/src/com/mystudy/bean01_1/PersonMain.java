package com.mystudy.bean01_1;

public class PersonMain {

	public static void main(String[] args) {
		Person person1 = new Person();
//		person1.name = "ȫ�浿";
		person1.age = -270;
		person1.showData();
		
		Person person2 = new Person();
		person2.setName("ȫ�浿");
		person2.setAge(-270);
		person2.showData();

	}

}
