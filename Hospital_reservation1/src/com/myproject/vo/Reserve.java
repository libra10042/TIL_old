package com.myproject.vo;

import java.util.Date;

public class Reserve {
	private int renumber; //에약번호
	private int clnumber; //고객번호
	private int donumber; //의사번호
	private String sympton; //증사
	private Date schedule; //예약날짜
	
	public Reserve() {
		// TODO Auto-generated constructor stub
	}

	public Reserve(int renumber, int clnumber, int donumber, String sympton, Date schedule) {
		super();
		this.renumber = renumber;
		this.clnumber = clnumber;
		this.donumber = donumber;
		this.sympton = sympton;
		this.schedule = schedule;
	}

	public int getRenumber() {
		return renumber;
	}

	public void setRenumber(int renumber) {
		this.renumber = renumber;
	}

	public int getClnumber() {
		return clnumber;
	}

	public void setClnumber(int clnumber) {
		this.clnumber = clnumber;
	}

	public int getDonumber() {
		return donumber;
	}

	public void setDonumber(int donumber) {
		this.donumber = donumber;
	}

	public String getSympton() {
		return sympton;
	}

	public void setSympton(String sympton) {
		this.sympton = sympton;
	}

	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Doctor [renumber=" + renumber + ", clnumber=" + clnumber + ", donumber=" + donumber + ", sympton="
				+ sympton + ", schedule=" + schedule + "]";
	}
	
	
	
	
	
	
	
	
}
