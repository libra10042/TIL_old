package com.bc.vo;

import java.util.Arrays;

public class PersonVO {
	private String name, age, gender;
	private String[] hobby;
	
	public PersonVO() { }

	public PersonVO(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

//	@Override
//	public String toString() {
//		return "PersonVO [name=" + name + ", age=" + age + ", gender=" + gender + ", hobby=" + Arrays.toString(hobby)
//				+ "]";
//	}
	
}
