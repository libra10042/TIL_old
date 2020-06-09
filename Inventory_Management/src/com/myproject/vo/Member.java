package com.myproject.vo;

public class Member {
	private String userId;
	private String userPw;
	private String name;
	private String address;
	private String phone;
	
	
	public Member() {

	}

	

	public Member(String userId, String userPw, String name, String address, String phone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



	public Member(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddrees() {
		return address;
	}


	public void setAddrees(String addrees) {
		this.address = addrees;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + ", name=" + name + ", addrees=" + address
				+ ", phone=" + phone + "]";
	}
	
	
	
	
}
