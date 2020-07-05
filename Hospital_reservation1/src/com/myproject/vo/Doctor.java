package com.myproject.vo;

public class Doctor {
	private int donumber;
	private int partnumber;
	private String doname;
	private String password;
	private String info_doctor;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(int donumber, int partnumber, String doname, String password, String info_doctor) {
		super();
		this.donumber = donumber;
		this.partnumber = partnumber;
		this.doname = doname;
		this.password = password;
		this.info_doctor = info_doctor;
	}

	public Doctor(int partnumber) {
		super();
		this.partnumber = partnumber;
	}

	public int getDonumber() {
		return donumber;
	}

	public void setDonumber(int donumber) {
		this.donumber = donumber;
	}

	public int getPartnumber() {
		return partnumber;
	}

	public void setPartnumber(int partnumber) {
		this.partnumber = partnumber;
	}

	public String getDoname() {
		return doname;
	}

	public void setDoname(String doname) {
		this.doname = doname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo_doctor() {
		return info_doctor;
	}

	public void setInfo_doctor(String info_doctor) {
		this.info_doctor = info_doctor;
	}

	@Override
	public String toString() {
		return "Doctor [donumber=" + donumber + ", partnumber=" + partnumber + ", doname=" + doname + ", password="
				+ password + ", info_doctor=" + info_doctor + "]";
	}
	
	
	
	
	
}
