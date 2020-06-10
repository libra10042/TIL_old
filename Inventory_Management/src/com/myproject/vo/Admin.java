package com.myproject.vo;

public class Admin {
	private String adminId;
	private String adminPw;
	private String name;
	private String addrees;
	private String phone; 
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminId, String adminPw, String name, String addrees, String phone) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.name = name;
		this.addrees = addrees;
		this.phone = phone;
	}

	public Admin(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrees() {
		return addrees;
	}

	public void setAddrees(String addrees) {
		this.addrees = addrees;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPw=" + adminPw + ", name=" + name + ", addrees=" + addrees
				+ ", phone=" + phone + "]";
	}
	
	
	
	
}
