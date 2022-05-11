package com.myproject.vo;

public class Clients {
	private int clnumber; //°í°´¹øÈ£ 
	private String clname; //°í°´ÀÌ¸§
	private String clpn; //°í°´ ÁÖ¹Î¹øÈ£
	private String clphone; //°í°´ÀüÈ­¹øÈ£
	
	public Clients() {
		// TODO Auto-generated constructor stub
	}

	public Clients(int clnumber, String clname, String clpn, String clphone) {
		super();
		this.clnumber = clnumber;
		this.clname = clname;
		this.clpn = clpn;
		this.clphone = clphone;
	}
	
	

	public Clients(String clphone) {
		super();
		this.clphone = clphone;
	}

	public Clients(String clname, String clpn) {
		super();
		this.clname = clname;
		this.clpn = clpn;
	}

	public Clients(int clnumber) {
		super();
		this.clnumber = clnumber;
	}

	public Clients(String clname, String clpn, String clphone) {
		super();
		this.clname = clname;
		this.clpn = clpn;
		this.clphone = clphone;
	}

	public int getClnumber() {
		return clnumber;
	}

	public void setClnumber(int clnumber) {
		this.clnumber = clnumber;
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
