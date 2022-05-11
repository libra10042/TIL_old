package com.mystudy.jdbc_dao;

// VO : Value Object - ������ ���� ��ü
// DTO : Data Transfer Object - ������ �����ϰ� �ְ� �ޱ� ���� ��ü
public class MemberVO {
	//DB�� Member ���̺�� ������ ������ �ʵ� ����
	private String id;
	private String name;
	private String password;
	private String phone;
	private String address;
	
	//�⺻������
	public MemberVO() { }
	
	//������(id,name,password,phone)
	public MemberVO(String id, String name, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}
	//������(��ü�ʵ�)
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
	
	// toString() �������̵�
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", address="
				+ address + "]";
	}
}









