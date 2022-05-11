package com.mystudy.jdbc_dao;

// VO : Value Object - 데이터 저장 객체
// DTO : Data Transfer Object - 데이터 저장하고 주고 받기 위한 객체
public class MemberVO {
	//DB의 Member 테이블과 동일한 형태의 필드 선언
	private String id;
	private String name;
	private String password;
	private String phone;
	private String address;
	
	//기본생성자
	public MemberVO() { }
	
	//생성자(id,name,password,phone)
	public MemberVO(String id, String name, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	//생성자(전체필드)
	public MemberVO(String id, String name, String password, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	
	//getters, setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	// toString() 오버라이딩
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", address="
				+ address + "]";
	}
}









