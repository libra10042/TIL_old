package com.mystudy.bean01_2;

import com.mystudy.bean01_1.Person;

public class PersonMain2 {

	public static void main(String[] args) {
		Person person1 = new Person();
//		person1.name = "È«±æµ¿";
//		person1.age = 27;
		
		person1.setName("È«±æµ¿");
		person1.setAge(27);
		person1.showData();
		
		String name = person1.getName();
		System.out.println("ÀÌ¸§ : " + name);

	}

}







