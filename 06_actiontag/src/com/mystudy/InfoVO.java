package com.mystudy;

public class InfoVO {
	private String name;
	private String age;
	
	public InfoVO() {}
	public InfoVO(String name, String age) {
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
	@Override
	public String toString() {
		return "InfoVO [name=" + name + ", age=" + age + "]";
	}
}
