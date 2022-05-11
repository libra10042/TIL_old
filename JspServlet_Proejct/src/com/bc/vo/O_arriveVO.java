package com.bc.vo;

public class O_arriveVO {
	private String userid, a_person, a_address, a_email, a_phone, a_message;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getA_person() {
		return a_person;
	}

	public void setA_person(String a_person) {
		this.a_person = a_person;
	}

	public String getA_address() {
		return a_address;
	}

	public void setA_address(String a_address) {
		this.a_address = a_address;
	}

	public String getA_email() {
		return a_email;
	}

	public void setA_email(String a_email) {
		this.a_email = a_email;
	}

	public String getA_phone() {
		return a_phone;
	}

	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}

	public String getA_message() {
		return a_message;
	}

	public void setA_message(String a_message) {
		this.a_message = a_message;
	}

	@Override
	public String toString() {
		return "O_arriveVO [userid=" + userid + ", a_person=" + a_person + ", a_address=" + a_address + ", a_email="
				+ a_email + ", a_phone=" + a_phone + ", a_message=" + a_message + "]";
	}
	
	
}
