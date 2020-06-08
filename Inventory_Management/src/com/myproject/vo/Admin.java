package com.myproject.vo;

public class Admin {
	private String adminName;  //������ �̸�
	private String adminId; //���̵�
	private String adminPw; //�н�����
	private String adminPhone; //�ڵ�����ȣ
	private String adminAddress; //�ּ�
	private String no; //ȸ�� ���� ���� 
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	
	public Admin(String adminName, String adminId, String adminPw, String adminPhone, String adminAddress, String no) {
		super();
		this.adminName = adminName;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminPhone = adminPhone;
		this.adminAddress = adminAddress;
		this.no = no;
	}


	public Admin(String adminName, String adminId, String adminPw, String adminPhone, String adminAddress) {
		super();
		this.adminName = adminName;
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminPhone = adminPhone;
		this.adminAddress = adminAddress;
	}
	
	
	

	public Admin(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	
	
	
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminId=" + adminId + ", adminPw=" + adminPw + ", adminPhone="
				+ adminPhone + ", adminAddress=" + adminAddress + "]";
	}

	
	
	
	
	
	

}
