package com.myproject.vo;

public class Clients {
	private int clunumber; //����ȣ 
	private String clname; //���̸�
	private String clpn; //�� �ֹι�ȣ
	private String clphone; //����ȭ��ȣ
	
	public Clients() {
		// TODO Auto-generated constructor stub
	}

	public Clients(int clunumber, String clname, String clpn, String clphone) {
		super();
		this.clunumber = clunumber;
		this.clname = clname;
		this.clpn = clpn;
		this.clphone = clphone;
	}
	
	
	
	

	public Clients(String clname, String clpn, String clphone) {
		super();
		this.clname = clname;
		this.clpn = clpn;
		this.clphone = clphone;
	}

	public int getClunumber() {
		return clunumber;
	}

	public void setClunumber(int clunumber) {
		this.clunumber = clunumber;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getClpn() {
		return clpn;
	}

	public void setClpn(String clpn) {
		this.clpn = clpn;
	}

	public String getClphone() {
		return clphone;
	}

	public void setClphone(String clphone) {
		this.clphone = clphone;
	}

	
	
	
	
	
	
	
}
